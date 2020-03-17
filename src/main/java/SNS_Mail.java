import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.sns.AmazonSNS;
import com.amazonaws.services.sns.AmazonSNSClient;
import com.amazonaws.services.sns.AmazonSNSClientBuilder;
import com.amazonaws.services.sns.model.CreateTopicRequest;
import com.amazonaws.services.sns.model.CreateTopicResult;
import com.amazonaws.services.sns.model.SubscribeRequest;

public class SNS_Mail {
	private static final String TOPIC_ARN_EMAIL = "Provide your topic arn here";

	private static final String EMAIL_SUBJECT = "This is a Test SNS Notification Mail";
	private static final String EMAIL_MESSAGE = "We are able to successfully trigger notification from SNS";
	
	private static final String EMAIL_SUBJECT_JAVA = "Test SNS Notification Mail From Java";
	private static final String EMAIL_MESSAGE_JAVA = "We are able to create topic, subscribe to that topic and publish to that topic from java";

	private static AmazonSNSClient snsClient = null;

	
	public static void main(String[] args) {
		// creating SNS client
		
		BasicAWSCredentials awsCreds = new BasicAWSCredentials("AWS_ACESS_KEY_ID", "AWS_SECRET_ACCESS_KEY");
		
		//Create SNS Client
		//replace region with your respective region
		AmazonSNS snsClient = AmazonSNSClient
                .builder()
                .withRegion(Regions.US_EAST_1)
                .withCredentials(new AWSStaticCredentialsProvider(awsCreds))
                .build();
		

		// Publish message to the topic
//		snsClient.publish(TOPIC_ARN_EMAIL, EMAIL_MESSAGE, EMAIL_SUBJECT);
		
		// Create an Amazon SNS topic.
//		final CreateTopicRequest createTopicRequest = new CreateTopicRequest("MyEmailTopicFromJava");
//		final CreateTopicResult createTopicResponse = snsClient.createTopic(createTopicRequest);
//		
//		// Print the topic ARN.
		String TOPIC_ARN_FROM_JAVA ="AWS_SNS_ARN";
		
		System.out.println("TopicArn:" + TOPIC_ARN_FROM_JAVA );
		
//		// Print the request ID for the CreateTopicRequest action.
//		System.out.println("CreateTopicRequest: " + snsClient.getCachedResponseMetadata(createTopicRequest));
//		
		//final SubscribeRequest subscribeRequest = new SubscribeRequest(TOPIC_ARN_FROM_JAVA, "email", "ajinkyapawar886@gmail.com");
		//snsClient.subscribe(subscribeRequest);
		
		snsClient.publish("AWS_ARN_TOPIC",EMAIL_MESSAGE_JAVA,EMAIL_SUBJECT_JAVA);
	}
}
