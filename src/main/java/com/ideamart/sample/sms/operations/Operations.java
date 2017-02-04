/*
 *Copyright 2015 Tharinda Dilshan Ehelepola
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.ideamart.sample.sms.operations;

import com.ideamart.sample.sms.send.SendMessage;
import com.ideamart.sample.usermgt.User;
import com.ideamart.sample.usermgt.UserDAO;
import hms.kite.samples.api.SdpException;
import hms.kite.samples.api.sms.messages.MoSmsReq;

import java.sql.SQLException;

import com.ideamart.sample.common.Constants;

/**
 * This class is created for do operations for messages.
 */
public class Operations {

    public void chat(String name, String message, String userAddress) {

    }

    public void getAnswer(String name, String address) {

    }

    public void sendErrorMessage(String address) {
        SendMessage sendMessage = new SendMessage();
        sendMessage.SendMessage("Oba kala yomu kireema waradiya", Constants.ApplicationConstants.APP_ID,
                address, Constants.ApplicationConstants.PASSWORD, Constants.ApplicationConstants.SMS_URL);
    }
}
