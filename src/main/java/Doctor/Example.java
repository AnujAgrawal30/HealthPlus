package Doctor;

import java.util.ArrayList;

import com.facebook.ads.sdk.APIContext;
import com.facebook.ads.sdk.AdAccount;
import com.facebook.ads.sdk.AdAccount.EnumCampaignStatus;
import com.facebook.ads.sdk.AdAccount.EnumCampaignObjective;
import com.facebook.ads.sdk.Campaign;
import com.facebook.ads.sdk.APIException;

public class Example {

  public static final String ACCESS_TOKEN = "[Your access token]";
  public static final Long ACCOUNT_ID = 0L;
  public static final String APP_SECRET = "[Your app secret]";

  public static final APIContext context = new APIContext(ACCESS_TOKEN, APP_SECRET);

public Example (ArrayList<ArrayList<String>> data) {
    try {
      AdAccount account = new AdAccount(ACCOUNT_ID, context, data);
      Campaign campaign = account.createCampaign()
        .setName("Java SDK Test Campaign")
        .setObjective(Campaign.EnumObjective.VALUE_LINK_CLICKS)
        .setSpendCap(10000L)
        .setStatus(Campaign.EnumStatus.VALUE_PAUSED)
        .execute();
      System.out.println(campaign.fetch());
    } catch (APIException e) {
      e.printStackTrace();
    }
  }
}
