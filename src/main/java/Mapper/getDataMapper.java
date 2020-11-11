package Mapper;

import service.RU.Formats.MessageType;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Base64;

public class getDataMapper {
    private static getDataMapper instance;
    private getDataMapper() {
    }

    public static getDataMapper getInstance(){
        if(instance == null){
            instance = new getDataMapper();
        }
        return instance;
    }


    public boolean saveMessageBody(MessageType.MessageMeta messageMeta, String content){
        try {
            Connection connection = ConnectionPool.getInstance().getConnection();
            connection.setAutoCommit(false);
            PreparedStatement preparedStatement = connection.prepareStatement
                    ("insert into RecievedMessage (messageType, preparationDateTime, consignmentID, envelopeID, initialEnvelopeID, contents)" +
                            " values (?,?,?,?,?,?)");

            preparedStatement.setString(1, messageMeta.getMessageKind());
            preparedStatement.setTimestamp(2, new Timestamp(messageMeta.getPreparationDateTime().toGregorianCalendar().getTimeInMillis()));
            preparedStatement.setString(3, messageMeta.getConsignmentId());
            preparedStatement.setString(4, messageMeta.getEnvelopeId());
            preparedStatement.setString(5, messageMeta.getInitialEnvelopeId());
            String hashContent = Base64.getEncoder().encodeToString(content.getBytes());
            preparedStatement.setString(6, hashContent);
            preparedStatement.addBatch();
            preparedStatement.executeBatch();
            preparedStatement.close();
            connection.commit();
            connection.close();
            return true;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }


    public boolean saveSingleMessageOfList(String envelopeID, String status) {

        if(status.equals("NEW")){
            try {
                Connection connection = ConnectionPool.getInstance().getConnection();
                connection.setAutoCommit(false);
                PreparedStatement preparedStatement = connection.prepareStatement
                        ("insert into RecievedMessagesList (envelopeID, status, date_time)" +
                                " values (?,?,?)");

                preparedStatement.setString(1, envelopeID);
                preparedStatement.setString(2, status);
                preparedStatement.setTimestamp(3,new Timestamp(System.currentTimeMillis()));

                preparedStatement.addBatch();
                preparedStatement.executeBatch();
                preparedStatement.close();
                connection.commit();
                connection.close();
                return true;

            } catch (SQLException e) {
                e.printStackTrace();
                return false;
            }
        }

        else{
            try {
                Connection connection = ConnectionPool.getInstance().getConnection();
                connection.setAutoCommit(false);
                PreparedStatement preparedStatement = connection.prepareStatement
                        ("UPDATE RecievedMessagesList SET status=?  WHERE envelopeID = ?");

                preparedStatement.setString(1, status);
                preparedStatement.setString(2, envelopeID);

                preparedStatement.addBatch();
                preparedStatement.executeBatch();
                preparedStatement.close();
                connection.commit();
                connection.close();
                return true;

            } catch (SQLException e) {
                e.printStackTrace();
                return false;
            }

        }
    }


}