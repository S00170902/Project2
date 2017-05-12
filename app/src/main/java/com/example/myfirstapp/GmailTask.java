package com.example.myfirstapp;

/*
Temboo generated code
 */

import android.os.AsyncTask;
import android.util.Log;
import android.widget.TextView;

import com.temboo.Library.Google.Gmail.SendEmail;
import com.temboo.core.TembooSession;

import static com.example.myfirstapp.MainActivity.EXTRA_MESSAGE;

public class GmailTask extends AsyncTask<Void, Void, String> {

private TextView textView;

public GmailTask(TextView textView){
        this.textView = textView;
        }

        TextView contentTxt = (TextView) textView.findViewById(R.id.scan_content);

@Override
protected String doInBackground(Void... arg0) {
        try {
// Create a new Temboo session.
            TembooSession session = new TembooSession("fdavey22", "projectTwo", "WlGEY1dWkWHnN48QnEZmEUOc4Dqhbrpb");


            SendEmail sendEmailChoreo = new SendEmail(session);

// Get an InputSet object for the choreo
            SendEmail.SendEmailInputSet sendEmailInputs = sendEmailChoreo.newInputSet();

// Set inputs
            sendEmailInputs.set_FromAddress("fdavey22@gmail.com");
            sendEmailInputs.set_Username("fdavey22@gmail.com");
            sendEmailInputs.set_Subject("Expiry Alert");
            sendEmailInputs.set_ToAddress("fdavey22@gmail.com");
            sendEmailInputs.set_MessageBody(EXTRA_MESSAGE + contentTxt);
            sendEmailInputs.set_Password("faaeaaifkpxbreya");

// Execute Choreo
            SendEmail.SendEmailResultSet sendEmailResults = sendEmailChoreo.execute(sendEmailInputs);

        return "SendEmail succeeded? " + sendEmailResults.get_Success();
        } catch(Exception e) {
        // if an exception occurred, log it
        Log.e(this.getClass().toString(), e.getMessage());
        }
        return null;
        }

protected void onPostExecute(String result) {
        try {
        textView.setText(result);
        } catch(Exception e) {
        // if an exception occurred, show an error message
        Log.e(this.getClass().toString(), e.getMessage());
        }
        }
}
