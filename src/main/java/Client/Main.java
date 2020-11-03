/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Client;

import java.io.StringReader;
import java.util.Date;
import java.util.Map;
import java.util.UUID;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.datatype.XMLGregorianCalendar;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.ws.BindingProvider;
import org.w3c.dom.Document;
import org.xml.sax.InputSource;
import service.RU.*;

/**
 *
 * @author @AmirShk
 */
public class Main {

    public static void main(String[] args) {
        //input sample
        String messageXML = "	<IR_Inf:Information xsi:schemaLocation=\"urn:customs.ru:IR_Information:1.0.0 IRInformation.xsd\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:cat_ru=\"urn:customs.ru:IRCommonAggregateTypes:1.0.0\" xmlns:IR_Inf=\"urn:customs.ru:IR_Information:1.0.0\">\n"
                + "			<cat_ru:DocumentID>IR2018110630100814237</cat_ru:DocumentID>\n"
                + "			<IR_Inf:DocumentDateTime>2020-03-14T08:48:13.196+03:30</IR_Inf:DocumentDateTime>\n"
                + "			<IR_Inf:ConsignmentIdentifier>IR20200518/45100/965612</IR_Inf:ConsignmentIdentifier>\n"
                + "			<IR_Inf:TransportInfo>\n"
                + "				<IR_Inf:ContainerNumber> \n"
                + "					<cat_ru:ContainerIdentificator>BULK123456-7</cat_ru:ContainerIdentificator>\n"
                + "					<cat_ru:Indicator>true</cat_ru:Indicator>\n"
                + "				</IR_Inf:ContainerNumber>\n"
                + "			</IR_Inf:TransportInfo>\n"
                + "			<IR_Inf:GoodsInfo>\n"
                + "				<IR_Inf:GoodsNumeric>1</IR_Inf:GoodsNumeric>\n"
                + "				<IR_Inf:GoodsTNVEDCode>03061700</IR_Inf:GoodsTNVEDCode>\n"
                + "				<IR_Inf:GoodsDescription>frozen shrimp Size 100-120</IR_Inf:GoodsDescription>\n"
                + "				<IR_Inf:GrossWeight>19833</IR_Inf:GrossWeight>\n"
                + "				<IR_Inf:NetWeight>18000</IR_Inf:NetWeight>\n"
                + "				<IR_Inf:AmountInvoice>57600</IR_Inf:AmountInvoice>\n"
                + "				<IR_Inf:Currency>840</IR_Inf:Currency>\n"
                + "				<IR_Inf:CountryDispatchCode>IR</IR_Inf:CountryDispatchCode>\n"
                + "				<IR_Inf:OriginCountryCode>IR</IR_Inf:OriginCountryCode>\n"
                + "				<IR_Inf:TotalPackageQuantity>1500</IR_Inf:TotalPackageQuantity>\n"
                + "				<IR_Inf:PackCode>PK</IR_Inf:PackCode>\n"
                + "				<IR_Inf:CurrencyExchangeRates>136721.0</IR_Inf:CurrencyExchangeRates>\n"
                + "				<IR_Inf:StatisticalCost>0</IR_Inf:StatisticalCost>\n"
                + "				<IR_Inf:CustomsCost>0</IR_Inf:CustomsCost>\n"
                + "				<IR_Inf:DeclNum>45100-965612</IR_Inf:DeclNum>\n"
                + "			</IR_Inf:GoodsInfo>\n"
                + "			<IR_Inf:PersonInfo>\n"
                + "				<IR_Inf:Consignor>\n"
                + "					<IR_Inf:OrganizationName>KALIPSO LLC</IR_Inf:OrganizationName>\n"
                + "					<IR_Inf:Address>119180, RUSSIA, MOSCOW, ST. POLYANKA B. BLD .51A / 9, FLOOR 8, AREA I,ROOM 1, OFFICE 102 TEL:8(910)432-32-12</IR_Inf:Address>\n"
                + "				</IR_Inf:Consignor>\n"
                + "				<IR_Inf:Consignee>\n"
                + "					<IR_Inf:OrganizationName>ALBORZ ABZIAN TRADING  </IR_Inf:OrganizationName>\n"
                + "					<IR_Inf:Address>POSTAL CODE: 1466975971</IR_Inf:Address>\n"
                + "				</IR_Inf:Consignee>\n"
                + "			</IR_Inf:PersonInfo>\n"
                + "			<IR_Inf:DocumentInfo>\n"
                + "				<IR_Inf:DeliveryTermsStringCode>FOB</IR_Inf:DeliveryTermsStringCode>\n"
                + "				<IR_Inf:InvoiceNumber>no-data</IR_Inf:InvoiceNumber>\n"
                + "				<IR_Inf:InvoiceDate>2020-02-19</IR_Inf:InvoiceDate>\n"
                + "				<IR_Inf:ConsignmentNoteNumber>no-data</IR_Inf:ConsignmentNoteNumber>\n"
                + "				<IR_Inf:ConsignmentNoteDate>2011-01-01</IR_Inf:ConsignmentNoteDate>\n"
                + "				<IR_Inf:ForeignTradeContractNumber>no-data</IR_Inf:ForeignTradeContractNumber>\n"
                + "				<IR_Inf:ForeignTradeContractDate>2011-01-01</IR_Inf:ForeignTradeContractDate>\n"
                + "			</IR_Inf:DocumentInfo>\n"
                + "		</IR_Inf:Information>";

        
        System.out.println(MessageHandler.getInstance().sendMessage(messageXML));

        // input sample
        String confirmxml = "<IRConfirm:Confirmation xmlns:IRConfirm=\"urn:customs.ru:IRConfirmation:1.0.0\" xmlns:cat_ru=\"urn:customs.ru:IRCommonAggregateTypes:1.0.0\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xsi:schemaLocation=\"urn:customs.ru:IRConfirmation:1.0.0 IRConfirmation.xsd\">\n"
                + "\n"
                + "<cat_ru:DocumentID>IR2020102912245014234</cat_ru:DocumentID>\n"
                + "\n"
                + "<cat_ru:RefDocumentID>35142DC9-92E2-9D01-8911-7D206E050A77</cat_ru:RefDocumentID>\n"
                + "\n"
                + "<IRConfirm:ConsignmentIdentifier>10013190/130620/0055072</IRConfirm:ConsignmentIdentifier>\n"
                + "\n"
                + "<IRConfirm:DateTime>2020-10-29T12:27:07.326+03:30</IRConfirm:DateTime>\n"
                + "\n"
                + "<IRConfirm:AceptanceTag>true</IRConfirm:AceptanceTag>\n"
                + "\n"
                + "\n"
                + "<IRConfirm:AceptanceInformation>\n"
                + "\n"
                + "<IRConfirm:Code>50000</IRConfirm:Code>\n"
                + "\n"
                + "</IRConfirm:AceptanceInformation>\n"
                + "\n"
                + "</IRConfirm:Confirmation>";
        /*try {
            ForeignApiService fas = new ForeignApiService();
            ForeignApi port = fas.getForeignApiEndpointPort();
            System.out.println(port);
            BindingProvider provider = (BindingProvider) port;
            Map<String, Object> context = provider.getRequestContext();
            context.put(BindingProvider.USERNAME_PROPERTY, "619369fe-e557-4d58-ade0-0f0f2434a320");
            context.put(BindingProvider.PASSWORD_PROPERTY, "PToE4M");
            //input sample
            String contentxml = "	<IR_Inf:Information xsi:schemaLocation=\"urn:customs.ru:IR_Information:1.0.0 IRInformation.xsd\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:cat_ru=\"urn:customs.ru:IRCommonAggregateTypes:1.0.0\" xmlns:IR_Inf=\"urn:customs.ru:IR_Information:1.0.0\">\n"
                    + "			<cat_ru:DocumentID>IR2018110630100814237</cat_ru:DocumentID>\n"
                    + "			<IR_Inf:DocumentDateTime>2020-03-14T08:48:13.196+03:30</IR_Inf:DocumentDateTime>\n"
                    + "			<IR_Inf:ConsignmentIdentifier>IR20200518/45100/965612</IR_Inf:ConsignmentIdentifier>\n"
                    + "			<IR_Inf:TransportInfo>\n"
                    + "				<IR_Inf:ContainerNumber> \n"
                    + "					<cat_ru:ContainerIdentificator>BULK123456-7</cat_ru:ContainerIdentificator>\n"
                    + "					<cat_ru:Indicator>true</cat_ru:Indicator>\n"
                    + "				</IR_Inf:ContainerNumber>\n"
                    + "			</IR_Inf:TransportInfo>\n"
                    + "			<IR_Inf:GoodsInfo>\n"
                    + "				<IR_Inf:GoodsNumeric>1</IR_Inf:GoodsNumeric>\n"
                    + "				<IR_Inf:GoodsTNVEDCode>03061700</IR_Inf:GoodsTNVEDCode>\n"
                    + "				<IR_Inf:GoodsDescription>frozen shrimp Size 100-120</IR_Inf:GoodsDescription>\n"
                    + "				<IR_Inf:GrossWeight>19833</IR_Inf:GrossWeight>\n"
                    + "				<IR_Inf:NetWeight>18000</IR_Inf:NetWeight>\n"
                    + "				<IR_Inf:AmountInvoice>57600</IR_Inf:AmountInvoice>\n"
                    + "				<IR_Inf:Currency>840</IR_Inf:Currency>\n"
                    + "				<IR_Inf:CountryDispatchCode>IR</IR_Inf:CountryDispatchCode>\n"
                    + "				<IR_Inf:OriginCountryCode>IR</IR_Inf:OriginCountryCode>\n"
                    + "				<IR_Inf:TotalPackageQuantity>1500</IR_Inf:TotalPackageQuantity>\n"
                    + "				<IR_Inf:PackCode>PK</IR_Inf:PackCode>\n"
                    + "				<IR_Inf:CurrencyExchangeRates>136721.0</IR_Inf:CurrencyExchangeRates>\n"
                    + "				<IR_Inf:StatisticalCost>0</IR_Inf:StatisticalCost>\n"
                    + "				<IR_Inf:CustomsCost>0</IR_Inf:CustomsCost>\n"
                    + "				<IR_Inf:DeclNum>45100-965612</IR_Inf:DeclNum>\n"
                    + "			</IR_Inf:GoodsInfo>\n"
                    + "			<IR_Inf:PersonInfo>\n"
                    + "				<IR_Inf:Consignor>\n"
                    + "					<IR_Inf:OrganizationName>KALIPSO LLC</IR_Inf:OrganizationName>\n"
                    + "					<IR_Inf:Address>119180, RUSSIA, MOSCOW, ST. POLYANKA B. BLD .51A / 9, FLOOR 8, AREA I,ROOM 1, OFFICE 102 TEL:8(910)432-32-12</IR_Inf:Address>\n"
                    + "				</IR_Inf:Consignor>\n"
                    + "				<IR_Inf:Consignee>\n"
                    + "					<IR_Inf:OrganizationName>ALBORZ ABZIAN TRADING  </IR_Inf:OrganizationName>\n"
                    + "					<IR_Inf:Address>POSTAL CODE: 1466975971</IR_Inf:Address>\n"
                    + "				</IR_Inf:Consignee>\n"
                    + "			</IR_Inf:PersonInfo>\n"
                    + "			<IR_Inf:DocumentInfo>\n"
                    + "				<IR_Inf:DeliveryTermsStringCode>FOB</IR_Inf:DeliveryTermsStringCode>\n"
                    + "				<IR_Inf:InvoiceNumber>no-data</IR_Inf:InvoiceNumber>\n"
                    + "				<IR_Inf:InvoiceDate>2020-02-19</IR_Inf:InvoiceDate>\n"
                    + "				<IR_Inf:ConsignmentNoteNumber>no-data</IR_Inf:ConsignmentNoteNumber>\n"
                    + "				<IR_Inf:ConsignmentNoteDate>2011-01-01</IR_Inf:ConsignmentNoteDate>\n"
                    + "				<IR_Inf:ForeignTradeContractNumber>no-data</IR_Inf:ForeignTradeContractNumber>\n"
                    + "				<IR_Inf:ForeignTradeContractDate>2011-01-01</IR_Inf:ForeignTradeContractDate>\n"
                    + "			</IR_Inf:DocumentInfo>\n"
                    + "		</IR_Inf:Information>";
            SendMessageRequestType parameters = CreatInformation(contentxml);
            SendMessageResponseType res = port.sendMessage(parameters);
            //after this we should call Res and Send Confirm
            System.out.println("resultCode: " + res.getResultCode() + "\n" + "resultDescription: " + res.getResultDescription());
        } catch (InvalidMessageException | MessageAlreadyExistException | UnknownException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }*/
    }



}
