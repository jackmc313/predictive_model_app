package predictive_model_app;

public class FrequencyTable 
{
	public static String outcome(String finalResult)
	{
		//the outcome titles are "has profile pic", "has email", "is active" and "above 100 followers"
		return switch (finalResult) {
		case "no,no,no,yes" -> "No (83% of the time)";
		case "no,no,no,no" -> "No (92% of the time)";
		case "no,no,yes,yes" -> "No (75% of the time)";
		case "no,no,yes,no" -> "No (67% of the time)";
		case "no,yes,no,yes" -> "No (58% of the time)";
		case "no,yes,no,no" -> "No (50% of the time)";
		case "no,yes,yes,yes" -> "Yes (58% of the time)";
		case "no,yes,yes,no" -> "Yes (67% of the time)";
		case "yes,no,no,yes" -> "No (75% of the time)";
		case "yes,no,no,no" -> "No (67% of the time)";
		case "yes,no,yes,yes" -> "No (58% of the time)";
		case "yes,no,yes,no" -> "Yes (50% of the time)";
		case "yes,yes,no,yes" -> "Yes (58% of the time)";
		case "yes,yes,no,no" -> "Yes (67% of the time)";
		case "yes,yes,yes,yes" -> "Yes (75% of the time)";
		case "yes,yes,yes,no" -> "Yes (83% of the time)";
		default -> "Please try a different combination";
				};
	}
}
