package com.ideamart.sample.ussd.receiver;

import com.ideamart.sample.common.Constants;
import com.ideamart.sample.sms.send.ScheduledMessage;
import com.ideamart.sample.sms.send.SendMessage;
import com.ideamart.sample.subcription.Subscription;
import com.ideamart.sample.usermgt.User;
import com.ideamart.sample.usermgt.UserDAO;
import hms.kite.samples.api.SdpException;
import hms.kite.samples.api.StatusCodes;
import hms.kite.samples.api.ussd.MoUssdListener;
import hms.kite.samples.api.ussd.UssdRequestSender;
import hms.kite.samples.api.ussd.messages.MoUssdReq;
import hms.kite.samples.api.ussd.messages.MtUssdReq;
import hms.kite.samples.api.ussd.messages.MtUssdResp;

import java.net.MalformedURLException;
import java.net.URL;
import java.sql.SQLException;

/**
 * This class is created to receive USSD messages
 */
public class Receiver implements MoUssdListener {


    private MoUssdReq moUssdReq;

    public MoUssdReq getMoUssdReq() {
        return moUssdReq;
    }

    public void setMoUssdReq(MoUssdReq moUssdReq) {
        this.moUssdReq = moUssdReq;
    }

    private UssdRequestSender ussdMtSender;

    @Override
    public void init() {
        try {
            ussdMtSender = new UssdRequestSender(new URL(Constants.ApplicationConstants.USSD_URL));
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onReceivedUssd(MoUssdReq moUssdReq) {

    }

    public MtUssdReq createRequest(MoUssdReq moUssdReq, String menuContent, String ussdOperation) {

        MtUssdReq request = new MtUssdReq();
        request.setApplicationId(moUssdReq.getApplicationId());
        request.setEncoding(moUssdReq.getEncoding());
        request.setMessage(menuContent);
        request.setPassword(Constants.ApplicationConstants.PASSWORD);
        request.setSessionId(moUssdReq.getSessionId());
        request.setUssdOperation(ussdOperation);
        request.setVersion(moUssdReq.getVersion());
        request.setDestinationAddress(moUssdReq.getSourceAddress());
        return request;
    }

    public MtUssdResp sendRequest(MtUssdReq request) throws SdpException {
        // sending request to service
        MtUssdResp response = null;
        try {
            System.out.println();
            response = ussdMtSender.sendUssdRequest(request);
        } catch (SdpException e) {
            throw e;
        }

        // response status
        String statusCode = response.getStatusCode();
        String statusDetails = response.getStatusDetail();
        //System.out.println(statusDetails);
        if (StatusCodes.SuccessK.equals(statusCode)) {
            System.out.println("Message sent succeeded");
        } else {
            System.out.println("Message sent failed");
        }
        return response;
    }
}
