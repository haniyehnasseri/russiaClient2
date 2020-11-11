package Mapper;

import service.RU.Formats.MessageType;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Base64;

public class sentDataMapper {
    private static sentDataMapper instance;
    private sentDataMapper() {
    }

    public static sentDataMapper getInstance(){
        if(instance == null){
            instance = new sentDataMapper();
        }
        return instance;
    }



    public boolean saveMessage(MessageType.MessageMeta messageMeta, String content, String type) {

        try {
            Connection connection = ConnectionPool.getInstance().getConnection();
            connection.setAutoCommit(false);
            PreparedStatement preparedStatement = connection.prepareStatement
                    ("insert into SentMessage (messageType, preparationDateTime, consignmentID, envelopeID, initialEnvelopeID, contents)" +
                            " values (?,?,?,?,?,?)");

            preparedStatement.setString(1, type);
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


}