package litserver.demo.application.services.utils;

import litserver.demo.domain.aggregrates.foodaggregate.FoodCategory;
import litserver.demo.domain.aggregrates.foodaggregate.FoodCondition;
import litserver.demo.domain.aggregrates.foodaggregate.FoodItem;
import litserver.demo.infrastructure.repositories.ICategoryRepository;
import litserver.demo.infrastructure.repositories.IFoodConditionRepository;
import litserver.demo.infrastructure.repositories.IFoodItemRepository;
import litserver.demo.infrastructure.repositories.IFoodRepository;
import litserver.demo.infrastructure.utils.XSSFDataExtracter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.sql.Date;
import java.util.*;

@Service
public class DatabaseInit {

    @Value("foodkeeper_data_path")
    private String foodKeeperDataPath;

    protected IFoodRepository foodRepository;
    protected IFoodItemRepository foodItemRepository;
    protected ICategoryRepository categoryRepository;
    protected IFoodConditionRepository foodCondition;

    Random random = new Random();
    List<String> companyBrands = new ArrayList<>();

    public static void main(String[] args) {
        DatabaseInit databaseInit = new DatabaseInit();
        databaseInit.populate(100);
    }

    public final void populate(int fooditemsamount){

        companyBrands.add("Kellogg");
        companyBrands.add("Danish Agro");
        companyBrands.add("Toms International");
        companyBrands.add("Løgismose Meyers");
        companyBrands.add("Ysco");
        companyBrands.add("Dr. Oetker");
        companyBrands.add("Győri Keksz");
        companyBrands.add("ABC Foods");
        companyBrands.add("Valeo Foods");
        companyBrands.add("Vion NV");

        populateCategories();
        populateFoodConditions();
        populateFoodItems(fooditemsamount);
        populateFoodAmounts();
    }
    public final void populateCategories(){

        try {
            HashMap<Integer, Object> category_names = XSSFDataExtracter.getData(foodKeeperDataPath, "Category_Name", new String());
            HashMap<Integer, Object> subcategory_names = XSSFDataExtracter.getData(foodKeeperDataPath, "Subcategory_Name", new String());

            if(category_names.size() == subcategory_names.size()){

                for(Map.Entry<Integer, Object> entry : category_names.entrySet()) {
                    Integer key = entry.getKey();
                    String category_name = entry.getValue().toString();
                    String subcategory_name = subcategory_names.get(key).toString();

                    categoryRepository.save(new FoodCategory(category_name, subcategory_name));
                }
            }
        } catch (IOException e) {
            System.out.println("Missing populating Categories");
            throw new RuntimeException(e);
        }
    }
    public final void populateFoodConditions(){

            foodCondition.save(new FoodCondition("Fresh", "Set regular prices."));
            foodCondition.save(new FoodCondition("Not expired", "Everything is fresh. Set regular prices."));
            foodCondition.save(new FoodCondition("Soon to expire", "Consider discount soon."));
            foodCondition.save(new FoodCondition("Just expired", "Consider discount."));
            foodCondition.save(new FoodCondition("Too much over expire date", "Throw it out as garbage :( "));
    }
    public final void populateFoodItems(int amount){

        long weeksMilliseconds = 604800000;
        long twentyWeeksMilliseconds = weeksMilliseconds * 20;
        long twoWeeksMilliseconds = weeksMilliseconds * 2;
        long timeNow = System.currentTimeMillis();

        try {
            HashMap<Integer, Object> productNames = XSSFDataExtracter.getData(foodKeeperDataPath, "Name", new String());
            HashMap<Integer, Object> subproductNames = XSSFDataExtracter.getData(foodKeeperDataPath, "Name_subtitle", new String());
            HashMap<Integer, Object> categoryIDs = XSSFDataExtracter.getData(foodKeeperDataPath, "Category_ID", Integer.class);

            if(productNames.size() == subproductNames.size() && productNames.size() == categoryIDs.size()){
                for (int i = 0; i < amount; i++) {
                    Integer randomKey = random.nextInt(1, productNames.size()+1);
                    final int key = randomKey;
                    String productName = productNames.get(key).toString();
                    String subproductName = subproductNames.get(key).toString();
                    Integer categoryID = Integer.valueOf(categoryIDs.get(key).toString());

                    Long randomFormerMilliseconds = random.nextLong(timeNow-twentyWeeksMilliseconds,timeNow);
                    Date randomProducedDate = new Date(randomFormerMilliseconds);

                    Long randomIntervalMilliseconds = random.nextLong(timeNow-twoWeeksMilliseconds,timeNow + twentyWeeksMilliseconds);
                    Date expirationDate = new Date(randomIntervalMilliseconds);

                    int randomBrandIndex = random.nextInt(1, companyBrands.size()+1);
                    String randomBrand = companyBrands.get(randomBrandIndex);

                    foodItemRepository.save(new FoodItem(randomProducedDate, expirationDate, productName, subproductName,
                            randomBrand, random.nextFloat(1.00F, 100.00F),
                            categoryRepository.findById(categoryID+1).get()));
                }
            }
        } catch (IOException e) {
            System.out.println("Missing populating Food Items");
            throw new RuntimeException(e);
        }

    }
    public final void populateFoodAmounts(){
        //TODO
        System.out.println("Still missing populating Food and amount");
    }
}
