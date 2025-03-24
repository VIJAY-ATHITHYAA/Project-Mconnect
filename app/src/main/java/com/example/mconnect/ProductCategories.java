package com.example.mconnect;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProductCategories {
    public static final String ACADEMIC_MATERIALS = "Academic Materials";
    public static final String ELECTRONICS = "Electronics";
    public static final String STATIONERY = "Stationery";
    public static final String BOOKS = "Books";
    public static final String LAB_EQUIPMENT = "Lab Equipment";
    public static final String MISCELLANEOUS = "Miscellaneous";

    public static List<String> getProductTypes() {
        List<String> types = new ArrayList<>();
        types.add(ACADEMIC_MATERIALS);
        types.add(ELECTRONICS);
        types.add(STATIONERY);
        types.add(BOOKS);
        types.add(LAB_EQUIPMENT);
        types.add(MISCELLANEOUS);
        return types;
    }

    public static Map<String, List<String>> getCategoriesByType() {
        Map<String, List<String>> categories = new HashMap<>();

        // Academic Materials
        List<String> academicItems = new ArrayList<>();
        academicItems.add("Textbooks");
        academicItems.add("Study Materials");
        academicItems.add("Project Reports");
        academicItems.add("Research Papers");
        academicItems.add("Previous Year Papers");
        categories.put(ACADEMIC_MATERIALS, academicItems);

        // Electronics
        List<String> electronics = new ArrayList<>();
        electronics.add("Arduino");
        electronics.add("Microcontrollers");
        electronics.add("Sensors");
        electronics.add("Development Boards");
        electronics.add("Electronic Components");
        electronics.add("Lab Equipment");
        electronics.add("Calculators");
        categories.put(ELECTRONICS, electronics);

        // Stationery
        List<String> stationery = new ArrayList<>();
        stationery.add("Notebooks");
        stationery.add("Drawing Equipment");
        stationery.add("Writing Materials");
        stationery.add("Art Supplies");
        stationery.add("Lab Notebooks");
        categories.put(STATIONERY, stationery);

        // Books
        List<String> books = new ArrayList<>();
        books.add("Academic Books");
        books.add("Reference Books");
        books.add("Engineering Books");
        books.add("Competitive Exam Books");
        books.add("Literature Books");
        categories.put(BOOKS, books);

        // Lab Equipment
        List<String> labEquipment = new ArrayList<>();
        labEquipment.add("Lab Coats");
        labEquipment.add("Safety Equipment");
        labEquipment.add("Lab Tools");
        labEquipment.add("Measurement Devices");
        labEquipment.add("Lab Accessories");
        categories.put(LAB_EQUIPMENT, labEquipment);

        // Miscellaneous
        List<String> misc = new ArrayList<>();
        misc.add("College Bags");
        misc.add("Project Materials");
        misc.add("Study Tables");
        misc.add("Storage Solutions");
        misc.add("Other Items");
        categories.put(MISCELLANEOUS, misc);

        return categories;
    }
} 