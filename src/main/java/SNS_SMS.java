import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.sns.AmazonSNS;
import com.amazonaws.services.sns.AmazonSNSClient;
import com.amazonaws.services.sns.model.PublishRequest;

public class SNS_SMS {

	public static void main(String[] args) {
		
		BasicAWSCredentials awsCreds = new BasicAWSCredentials("AWS_ACESS_KEY_ID", "AWS_SECRET_ACCESS_KEY");
		
		//Create SNS Client
		// replace AWS Region with your respective region
		AmazonSNS snsClient = AmazonSNSClient
                .builder()
                .withRegion(Regions.US_EAST_1)
                .withCredentials(new AWSStaticCredentialsProvider(awsCreds))
                .build();
		
		String SMSMessage = "WRITE YOUR MESSAGE HERE";
		String mobile = "+91xxxxxxxxxx";//Enter your mobile number here
		
		snsClient.publish(new PublishRequest().withMessage(SMSMessage).withPhoneNumber(mobile));
		

	}

}
