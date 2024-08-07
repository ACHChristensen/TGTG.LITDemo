package litserver.demo.application.services.utils;

import litserver.demo.domain.aggregrates.foodaggregate.Food;
import litserver.demo.domain.aggregrates.foodaggregate.FoodCategory;
import litserver.demo.domain.aggregrates.foodaggregate.FoodCondition;
import litserver.demo.domain.aggregrates.foodaggregate.FoodItem;
import litserver.demo.infrastructure.repositories.ICategoryRepository;
import litserver.demo.infrastructure.repositories.IFoodConditionRepository;
import litserver.demo.infrastructure.repositories.IFoodItemRepository;
import litserver.demo.infrastructure.repositories.IFoodRepository;
import litserver.demo.infrastructure.utils.XSSFDataExtracter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.*;

@Configuration
@Service
public class DatabaseInit {

    @Autowired
    private IFoodRepository foodRepository;
    @Autowired
    private IFoodItemRepository foodItemRepository;

    @Autowired
    private ICategoryRepository categoryRepository;
    @Autowired
    private IFoodConditionRepository foodConditionRepository;


    private XSSFDataExtracter XSSFDATAEXTRACTER = new XSSFDataExtracter();
    List<FoodItem> foodItems = new ArrayList<>();
    Random random = new Random();
    List<String> companyBrands = new ArrayList<>();
    long timeNow = System.currentTimeMillis();


    public final long populate(int foodItemsAmount){

        companyBrands.add("Kellogg");
        companyBrands.add("Arla");
        companyBrands.add("Coop");
        companyBrands.add("Carlsberg");
        companyBrands.add("Irma");
        companyBrands.add("ALDI");
        companyBrands.add("AM Food");
        companyBrands.add("Baby Sam");
        companyBrands.add("Bahne");
        companyBrands.add("Bilka");
        companyBrands.add("Brugsen");
        companyBrands.add("Bøgely");
        companyBrands.add("HS Slik");
        companyBrands.add("Hurlehej Købmand");
        companyBrands.add("Iscyklen - Based on Nature");
        companyBrands.add("Kaffe & Ko");
        companyBrands.add("IAN BAZAR");
        companyBrands.add("ABC Lavpris");
        companyBrands.add("Kagehuset");
        companyBrands.add("Kaptajn Kandis");
        companyBrands.add("Danish Agro");
        companyBrands.add("Toms International");
        companyBrands.add("Løgismose Meyers");
        companyBrands.add("Kofoed");
        companyBrands.add("Let-Køb");
        companyBrands.add("Ysco");
        companyBrands.add("Kvickly");
        companyBrands.add("Køge Frugt & Grønt");
        companyBrands.add("Lakrids by Bülow");
        companyBrands.add("Dr. Oetker");
        companyBrands.add("Győri Keksz");
        companyBrands.add("Langhorn");
        companyBrands.add("ABC Foods");
        companyBrands.add("Valeo Foods");
        companyBrands.add("Vion NV");

        if(categoryRepository.count() == 0){
            populateCategories();
        }
        if(foodConditionRepository.count() == 0){
            populateFoodConditions();
        }

        populateFoodItems(foodItemsAmount);
        populateFoodAmounts();

        return foodRepository.count();
    }
    public final void populateCategories(){
        try {
            HashMap<Integer, Object> category_names = this.XSSFDATAEXTRACTER.getData("Category_Name", new String(), 1);
            HashMap<Integer, Object> subcategory_names = this.XSSFDATAEXTRACTER.getData("Subcategory_Name", new String(), 1);
            if(category_names.size() == subcategory_names.size()){
               for(Map.Entry<Integer, Object> entry : category_names.entrySet()) {
                    Integer key = entry.getKey();
                    String category_name = entry.getValue().toString();
                    String subcategory_name = subcategory_names.get(key).toString();
                    boolean hasWrittenExpiryDate;
                    if(
                            category_name.equals("Baked Goods") && subcategory_name.equals("Bakery")
                            || category_name.equals("Produce")
                            || category_name.equals("Deli & Prepared Foods")
                    ){
                        hasWrittenExpiryDate = false;
                    }else{
                        hasWrittenExpiryDate = true;
                    }
                    FoodCategory foodCategory = new FoodCategory(category_name, subcategory_name, hasWrittenExpiryDate);
                    this.categoryRepository.save(foodCategory);
                }
                System.out.println(this.categoryRepository.count());
            }
        } catch (IOException e) {
            System.out.println("Missing populating Food Categories");
            throw new RuntimeException(e);
        }
    }
    public final void populateFoodConditions(){

        this.foodConditionRepository.save(new FoodCondition("Fresh", "", false));
        this.foodConditionRepository.save(new FoodCondition("Still fresh?", "Smell and/or look at the product.", false));
        this.foodConditionRepository.save(new FoodCondition("Not expired", "", true));
        this.foodConditionRepository.save(new FoodCondition("Soon to expire", "Consider discount soon, donation or Surprice Bags.", true));
        this.foodConditionRepository.save(new FoodCondition("Expires today", "Consider huge discount or Surprice Bags.", true));
        this.foodConditionRepository.save(new FoodCondition("Over expiry date", "Donate it? ", true));
    }
    public final void populateFoodItems(int amount){

        long weeksMilliseconds = 604800000;
        long twentyWeeksMilliseconds = weeksMilliseconds * 20;
        long twoWeeksMilliseconds = weeksMilliseconds * 2;


        try {
            HashMap<Integer, Object> productNames = this.XSSFDATAEXTRACTER.getData( "Name", new String(), 2);
            HashMap<Integer, Object> subproductNames = this.XSSFDATAEXTRACTER.getData( "Name_subtitle", new String(),2);
            HashMap<Integer, Object> categoryIDs = this.XSSFDATAEXTRACTER.getData("Category_ID", Integer.valueOf("1"),2); // To have Integer as object

            if(productNames.size() == subproductNames.size() && productNames.size() == categoryIDs.size()){
                for (int i = 0; i < amount-1; i++) {
                    Integer randomKey = random.nextInt(1, categoryIDs.size()+1);
                    int KEY = randomKey;
                    String productName = productNames.get(KEY).toString();
                    String subproductName = subproductNames.get(KEY).toString();

                    if(categoryIDs.get(KEY) == ""){

                        continue;
                    }

                    Integer categoryID = Integer.valueOf(categoryIDs.get(KEY).toString());

                    Long randomFormerMilliseconds = random.nextLong(timeNow-twentyWeeksMilliseconds,timeNow);
                    Date randomProducedDate = new Date(randomFormerMilliseconds);

                    Long randomIntervalMilliseconds = random.nextLong(timeNow-twoWeeksMilliseconds,timeNow + twentyWeeksMilliseconds);
                    Date expirationDate = new Date(randomIntervalMilliseconds);

                    int randomBrandIndex = random.nextInt(0, companyBrands.size());
                    String randomBrand = companyBrands.get(randomBrandIndex);

                    Float priceFromRandomNumberString = Float.valueOf(String.format(Locale.US, "%.2f", (random.nextFloat(1.00F, 100.00F))));
                    System.out.println("ID " + categoryID);
                    FoodItem foodItem = foodItemRepository.save(
                            new FoodItem(
                                    randomProducedDate, expirationDate, productName, subproductName,
                                    randomBrand, priceFromRandomNumberString,
                                    categoryRepository.findById(categoryID).get()
                            )
                    );
                    foodItems.add(foodItem);
                }
            }
        } catch (IOException e) {
            System.out.println("Missing populating Food Items");
            throw new RuntimeException(e);
        }

    }
    public final void populateFoodAmounts(){

        FoodCondition fresh = foodConditionRepository.getConditionsWithNOExpiryDateAndRecommendation( "").get(); //Has not expiry date
        FoodCondition freshBeforeExpDate = foodConditionRepository.getConditionsWithExpiryDateAndRecommendation("").get(); //Has expiry date
        Date today = new Date(timeNow);

        foodItems.forEach((foodItem) -> {
            int quantity = random.nextInt(1,40+1);

            FoodCondition foodCondition;
            if(foodItem.getFoodCategory().getHasWrittenExpiryDate() //If product has an expiry date
            //&& today.compareTo(foodItem.getExpirationDate()) < 0
            ){
                foodCondition = freshBeforeExpDate;

            } else {
                foodCondition = fresh;
            }
            foodRepository.save(new Food(quantity, 0, 0,foodItem,foodCondition));
        });
    }
}
