package com.usabb.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.lang.reflect.Field;
import java.util.*;

@JsonIgnoreProperties(ignoreUnknown = true)
public class BaseProduct {
    @JsonProperty("Base Model")
    private String baseModel;
    @JsonProperty("Similar products")
    private String upsell;
    @JsonProperty("This Product Goes Well With")
    private String crossSell;
    @JsonProperty("Series")
    private String series;
    @JsonProperty("Product Group_PDP")
    private String productGroupPDP;
    @JsonProperty("Product Group_CAT")
    private String productGroupCAT;
    @JsonProperty("Product Name")
    private String productName;
    @JsonProperty("Long Description")
    private String longDescription;
    @JsonProperty("Feature 1")
    private String feature1;
    @JsonProperty("Feature 2")
    private String feature2;
    @JsonProperty("Feature 3")
    private String feature3;
    @JsonProperty("Feature 4")
    private String feature4;
    @JsonProperty("Feature 5")
    private String feature5;
    @JsonProperty("Feature 6")
    private String feature6;
    @JsonProperty("Feature 7")
    private String feature7;
    @JsonProperty("Feature 8")
    private String feature8;
    @JsonProperty("Feature 9")
    private String feature9;
    @JsonProperty("Feature 10")
    private String feature10;
    @JsonProperty("Style (Body Plan)")
    private String style;
    @JsonProperty("Seat height")
    private String seatHeight;
    @JsonProperty("Desk/Table Top Width")
    private String deskTableTopWidth;
    @JsonProperty("Desk/Table Depth")
    private String deskTableDepth;
    @JsonProperty("Desk/Table Top Length")
    private String deskTableTopLength;
    @JsonProperty("Desk/Table Top Diameter for Rounds")
    private String deskTableTopDiameterForRounds;
    @JsonProperty("Desk/Table Top Diameter")
    private String deskTableTopDiameter;
    @JsonProperty("Desk/Table Height")
    private String deskTableHeight;
    @JsonProperty("Desk/Table Top Thickness")
    private String deskTableTopThickness;
    @JsonProperty("Storage Size")
    private String storageSize;
    @JsonProperty("Overall Width")
    private double overallWidth;
    @JsonProperty("Overall Depth")
    private String overallDepth;
    @JsonProperty("Overall Height")
    private double overallHeight;
    @JsonProperty("Unit per carton")
    private double unitPerCarton;
    @JsonProperty("Total product weight")
    private double totalProductWeight;
    @JsonProperty("Total Carton weight")
    private double totalCartonWeight;
    @JsonProperty("Leg or Height Adjustability")
    private String legOrHeightAdjustability;
    @JsonProperty("Wheelchair Height")
    private String wheelchairHeight;
    @JsonProperty("Low-range legs")
    private String lowRangeLegs;
    @JsonProperty("Stand-up legs")
    private String standUpLegs;
    @JsonProperty("Leg Option")
    private String legOption;
    @JsonProperty("All-Chrome legs")
    private String allChromeLegs;
    @JsonProperty("Extra Large Seat")
    private String extraLargeSeat;
    @JsonProperty("Padded Seat")
    private String paddedSeat;
    @JsonProperty("Fire-Resistent")
    private String fireResistent;
    @JsonProperty("Rust Preventative Powder Coat")
    private String rustPreventativePowderCoat;
    @JsonProperty("Arms")
    private String arms;
    @JsonProperty("Book rack")
    private String bookRack;
    @JsonProperty("Stack bar")
    private String stackBar;
    @JsonProperty("Pneumatic")
    private String pneumatic;
    @JsonProperty("Cross brace")
    private String crossBrace;
    @JsonProperty("Backpack hanger")
    private String backpackHanger;
    @JsonProperty("Type of tablet arm")
    private String typeOfTabletArm;
    @JsonProperty("Suited for Writing Hand")
    private String suitedForWritingHand;
    @JsonProperty("Book box/Trays")
    private String bookBoxTrays;
    @JsonProperty("Package Option")
    private String packageOption;
    @JsonProperty("Grommet")
    private String grommet;
    @JsonProperty("Glides/Casters")
    private String glidesCasters;
    @JsonProperty("Ganging Device")
    private String gangingDevice;
    @JsonProperty("Riser")
    private String riser;
    @JsonProperty("Shelf")
    private String shelf;
    @JsonProperty("Storage back")
    private String storageBack;
    @JsonProperty("Storage Configuration")
    private String storageConfiguration;
    @JsonProperty("Capacity")
    private String capacity;
    @JsonProperty("Specification Sheet  name")
    private String specificationSheetName;
    @JsonProperty("Assembly Required")
    private String assemblyRequired;
    @JsonProperty("Liftgate recommended")
    private String liftgateRecommended;
    @JsonProperty("Shapes for desks and tables")
    private String shapesForDesksAndTables;
    @JsonProperty("Mobile")
    private String mobile;
    @JsonProperty("Recommended Grade Level")
    private String recommendedGradeLevel;
    @JsonProperty("Overhead Storage")
    private String overheadStorage;
    @JsonProperty("Screen")
    private String screen;
    @JsonProperty("Supports (TBD)")
    private String supports;
    @JsonProperty("Seat material")
    private String seatMaterial;
    @JsonProperty("Pad material")
    private String padMaterial;
    @JsonProperty("Desk/Table top material")
    private String deskTableTopMaterial;
    @JsonProperty("Desk/Table edge material")
    private String deskTableEdgeMaterial;
    @JsonProperty("Panel Material")
    private String panelMaterial;
    @JsonProperty("Screen Material")
    private String screenMaterial;
    @JsonProperty("Bench edge material")
    private String benchEdgeMaterial;
    @JsonProperty("Box/Tray Color")
    private String boxTrayColor;
    @JsonProperty("Arm Color")
    private String armColor;
    @JsonProperty("Finish Options")
    private String finishOptions;
    @JsonProperty("Representative Image")
    private String representativeImage;
    @JsonProperty("FUNCTIONAL CATEGORY")
    private String functionalCategory;
    @JsonProperty("Unconfigured Product Name")
    private String unconfiguredProductName;
    @JsonProperty("Configured Product Name")
    private String configuredProductName;
    @JsonProperty("Accessories")
    private String accessories;

    public String getBaseModel() {
        return baseModel;
    }

    public void setBaseModel(String baseModel) {
        this.baseModel = baseModel;
    }

    public String getUpsell() {
        return upsell;
    }

    public void setUpsell(String upsell) {
        this.upsell = upsell;
    }

    public String getCrossSell() {
        return crossSell;
    }

    public void setCrossSell(String crossSell) {
        this.crossSell = crossSell;
    }

    public String getSeries() {
        return series;
    }

    public void setSeries(String series) {
        this.series = series;
    }

    public List<String> getCrossSellArray() {
        List<String> list = new ArrayList<>();
        if (crossSell != null) list.addAll(Arrays.asList(crossSell.split(",")));
        return list;
    }

    public List<String> getUpSellArray() {
        List<String> list = new ArrayList<>();
        if (upsell != null) list.addAll(Arrays.asList(upsell.split(",")));
        return list;
    }

    public String getProductGroupPDP() {
        return productGroupPDP;
    }

    public void setProductGroupPDP(String productGroupPDP) {
        this.productGroupPDP = productGroupPDP;
    }

    public String getProductGroupCAT() {
        return productGroupCAT;
    }

    public void setProductGroupCAT(String productGroupCAT) {
        this.productGroupCAT = productGroupCAT;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getLongDescription() {
        return longDescription;
    }

    public void setLongDescription(String longDescription) {
        this.longDescription = longDescription;
    }

    public String getFeature1() {
        return feature1;
    }

    public void setFeature1(String feature1) {
        this.feature1 = feature1;
    }

    public String getFeature2() {
        return feature2;
    }

    public void setFeature2(String feature2) {
        this.feature2 = feature2;
    }

    public String getFeature3() {
        return feature3;
    }

    public void setFeature3(String feature3) {
        this.feature3 = feature3;
    }

    public String getFeature4() {
        return feature4;
    }

    public void setFeature4(String feature4) {
        this.feature4 = feature4;
    }

    public String getFeature5() {
        return feature5;
    }

    public void setFeature5(String feature5) {
        this.feature5 = feature5;
    }

    public String getFeature6() {
        return feature6;
    }

    public void setFeature6(String feature6) {
        this.feature6 = feature6;
    }

    public String getFeature7() {
        return feature7;
    }

    public void setFeature7(String feature7) {
        this.feature7 = feature7;
    }

    public String getFeature8() {
        return feature8;
    }

    public void setFeature8(String feature8) {
        this.feature8 = feature8;
    }

    public String getFeature9() {
        return feature9;
    }

    public void setFeature9(String feature9) {
        this.feature9 = feature9;
    }

    public String getFeature10() {
        return feature10;
    }

    public void setFeature10(String feature10) {
        this.feature10 = feature10;
    }

    public String getStyle() {
        return style;
    }

    public void setStyle(String style) {
        this.style = style;
    }

    public String getSeatHeight() {
        return seatHeight;
    }

    public void setSeatHeight(String seatHeight) {
        this.seatHeight = seatHeight;
    }

    public String getDeskTableTopWidth() {
        return deskTableTopWidth;
    }

    public void setDeskTableTopWidth(String deskTableTopWidth) {
        this.deskTableTopWidth = deskTableTopWidth;
    }

    public String getDeskTableDepth() {
        return deskTableDepth;
    }

    public void setDeskTableDepth(String deskTableDepth) {
        this.deskTableDepth = deskTableDepth;
    }

    public String getDeskTableTopLength() {
        return deskTableTopLength;
    }

    public void setDeskTableTopLength(String deskTableTopLength) {
        this.deskTableTopLength = deskTableTopLength;
    }

    public String getDeskTableTopDiameterForRounds() {
        return deskTableTopDiameterForRounds;
    }

    public void setDeskTableTopDiameterForRounds(String deskTableTopDiameterForRounds) {
        this.deskTableTopDiameterForRounds = deskTableTopDiameterForRounds;
    }

    public String getDeskTableTopDiameter() {
        return deskTableTopDiameter;
    }

    public void setDeskTableTopDiameter(String deskTableTopDiameter) {
        this.deskTableTopDiameter = deskTableTopDiameter;
    }

    public String getDeskTableHeight() {
        return deskTableHeight;
    }

    public void setDeskTableHeight(String deskTableHeight) {
        this.deskTableHeight = deskTableHeight;
    }

    public String getDeskTableTopThickness() {
        return deskTableTopThickness;
    }

    public void setDeskTableTopThickness(String deskTableTopThickness) {
        this.deskTableTopThickness = deskTableTopThickness;
    }

    public String getStorageSize() {
        return storageSize;
    }

    public void setStorageSize(String storageSize) {
        this.storageSize = storageSize;
    }

    public double getOverallWidth() {
        return overallWidth;
    }

    public void setOverallWidth(double overallWidth) {
        this.overallWidth = overallWidth;
    }

    public String getOverallDepth() {
        return overallDepth;
    }

    public void setOverallDepth(String overallDepth) {
        this.overallDepth = overallDepth;
    }

    public double getOverallHeight() {
        return overallHeight;
    }

    public void setOverallHeight(double overallHeight) {
        this.overallHeight = overallHeight;
    }

    public double getUnitPerCarton() {
        return unitPerCarton;
    }

    public void setUnitPerCarton(double unitPerCarton) {
        this.unitPerCarton = unitPerCarton;
    }

    public double getTotalProductWeight() {
        return totalProductWeight;
    }

    public void setTotalProductWeight(double totalProductWeight) {
        this.totalProductWeight = totalProductWeight;
    }

    public double getTotalCartonWeight() {
        return totalCartonWeight;
    }

    public void setTotalCartonWeight(double totalCartonWeight) {
        this.totalCartonWeight = totalCartonWeight;
    }

    public String getLegOrHeightAdjustability() {
        return legOrHeightAdjustability;
    }

    public void setLegOrHeightAdjustability(String legOrHeightAdjustability) {
        this.legOrHeightAdjustability = legOrHeightAdjustability;
    }

    public String getWheelchairHeight() {
        return wheelchairHeight;
    }

    public void setWheelchairHeight(String wheelchairHeight) {
        this.wheelchairHeight = wheelchairHeight;
    }

    public String getLowRangeLegs() {
        return lowRangeLegs;
    }

    public void setLowRangeLegs(String lowRangeLegs) {
        this.lowRangeLegs = lowRangeLegs;
    }

    public String getStandUpLegs() {
        return standUpLegs;
    }

    public void setStandUpLegs(String standUpLegs) {
        this.standUpLegs = standUpLegs;
    }

    public String getLegOption() {
        return legOption;
    }

    public void setLegOption(String legOption) {
        this.legOption = legOption;
    }

    public String getAllChromeLegs() {
        return allChromeLegs;
    }

    public void setAllChromeLegs(String allChromeLegs) {
        this.allChromeLegs = allChromeLegs;
    }

    public String getExtraLargeSeat() {
        return extraLargeSeat;
    }

    public void setExtraLargeSeat(String extraLargeSeat) {
        this.extraLargeSeat = extraLargeSeat;
    }

    public String getPaddedSeat() {
        return paddedSeat;
    }

    public void setPaddedSeat(String paddedSeat) {
        this.paddedSeat = paddedSeat;
    }

    public String getFireResistent() {
        return fireResistent;
    }

    public void setFireResistent(String fireResistent) {
        this.fireResistent = fireResistent;
    }

    public String getRustPreventativePowderCoat() {
        return rustPreventativePowderCoat;
    }

    public void setRustPreventativePowderCoat(String rustPreventativePowderCoat) {
        this.rustPreventativePowderCoat = rustPreventativePowderCoat;
    }

    public String getArms() {
        return arms;
    }

    public void setArms(String arms) {
        this.arms = arms;
    }

    public String getBookRack() {
        return bookRack;
    }

    public void setBookRack(String bookRack) {
        this.bookRack = bookRack;
    }

    public String getStackBar() {
        return stackBar;
    }

    public void setStackBar(String stackBar) {
        this.stackBar = stackBar;
    }

    public String getPneumatic() {
        return pneumatic;
    }

    public void setPneumatic(String pneumatic) {
        this.pneumatic = pneumatic;
    }

    public String getCrossBrace() {
        return crossBrace;
    }

    public void setCrossBrace(String crossBrace) {
        this.crossBrace = crossBrace;
    }

    public String getBackpackHanger() {
        return backpackHanger;
    }

    public void setBackpackHanger(String backpackHanger) {
        this.backpackHanger = backpackHanger;
    }

    public String getTypeOfTabletArm() {
        return typeOfTabletArm;
    }

    public void setTypeOfTabletArm(String typeOfTabletArm) {
        this.typeOfTabletArm = typeOfTabletArm;
    }

    public String getSuitedForWritingHand() {
        return suitedForWritingHand;
    }

    public void setSuitedForWritingHand(String suitedForWritingHand) {
        this.suitedForWritingHand = suitedForWritingHand;
    }

    public String getBookBoxTrays() {
        return bookBoxTrays;
    }

    public void setBookBoxTrays(String bookBoxTrays) {
        this.bookBoxTrays = bookBoxTrays;
    }

    public String getPackageOption() {
        return packageOption;
    }

    public void setPackageOption(String packageOption) {
        this.packageOption = packageOption;
    }

    public String getGrommet() {
        return grommet;
    }

    public void setGrommet(String grommet) {
        this.grommet = grommet;
    }

    public String getGlidesCasters() {
        return glidesCasters;
    }

    public void setGlidesCasters(String glidesCasters) {
        this.glidesCasters = glidesCasters;
    }

    public String getGangingDevice() {
        return gangingDevice;
    }

    public void setGangingDevice(String gangingDevice) {
        this.gangingDevice = gangingDevice;
    }

    public String getRiser() {
        return riser;
    }

    public void setRiser(String riser) {
        this.riser = riser;
    }

    public String getShelf() {
        return shelf;
    }

    public void setShelf(String shelf) {
        this.shelf = shelf;
    }

    public String getStorageBack() {
        return storageBack;
    }

    public void setStorageBack(String storageBack) {
        this.storageBack = storageBack;
    }

    public String getStorageConfiguration() {
        return storageConfiguration;
    }

    public void setStorageConfiguration(String storageConfiguration) {
        this.storageConfiguration = storageConfiguration;
    }

    public String getCapacity() {
        return capacity;
    }

    public void setCapacity(String capacity) {
        this.capacity = capacity;
    }

    public String getSpecificationSheetName() {
        return specificationSheetName;
    }

    public void setSpecificationSheetName(String specificationSheetName) {
        this.specificationSheetName = specificationSheetName;
    }

    public String getAssemblyRequired() {
        return assemblyRequired;
    }

    public void setAssemblyRequired(String assemblyRequired) {
        this.assemblyRequired = assemblyRequired;
    }

    public String getLiftgateRecommended() {
        return liftgateRecommended;
    }

    public void setLiftgateRecommended(String liftgateRecommended) {
        this.liftgateRecommended = liftgateRecommended;
    }

    public String getShapesForDesksAndTables() {
        return shapesForDesksAndTables;
    }

    public void setShapesForDesksAndTables(String shapesForDesksAndTables) {
        this.shapesForDesksAndTables = shapesForDesksAndTables;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getRecommendedGradeLevel() {
        return recommendedGradeLevel;
    }

    public void setRecommendedGradeLevel(String recommendedGradeLevel) {
        this.recommendedGradeLevel = recommendedGradeLevel;
    }

    public String getOverheadStorage() {
        return overheadStorage;
    }

    public void setOverheadStorage(String overheadStorage) {
        this.overheadStorage = overheadStorage;
    }

    public String getScreen() {
        return screen;
    }

    public void setScreen(String screen) {
        this.screen = screen;
    }

    public String getSupports() {
        return supports;
    }

    public void setSupports(String supports) {
        this.supports = supports;
    }

    public String getSeatMaterial() {
        return seatMaterial;
    }

    public void setSeatMaterial(String seatMaterial) {
        this.seatMaterial = seatMaterial;
    }

    public String getPadMaterial() {
        return padMaterial;
    }

    public void setPadMaterial(String padMaterial) {
        this.padMaterial = padMaterial;
    }

    public String getDeskTableTopMaterial() {
        return deskTableTopMaterial;
    }

    public void setDeskTableTopMaterial(String deskTableTopMaterial) {
        this.deskTableTopMaterial = deskTableTopMaterial;
    }

    public String getDeskTableEdgeMaterial() {
        return deskTableEdgeMaterial;
    }

    public void setDeskTableEdgeMaterial(String deskTableEdgeMaterial) {
        this.deskTableEdgeMaterial = deskTableEdgeMaterial;
    }

    public String getPanelMaterial() {
        return panelMaterial;
    }

    public void setPanelMaterial(String panelMaterial) {
        this.panelMaterial = panelMaterial;
    }

    public String getScreenMaterial() {
        return screenMaterial;
    }

    public void setScreenMaterial(String screenMaterial) {
        this.screenMaterial = screenMaterial;
    }

    public String getBenchEdgeMaterial() {
        return benchEdgeMaterial;
    }

    public void setBenchEdgeMaterial(String benchEdgeMaterial) {
        this.benchEdgeMaterial = benchEdgeMaterial;
    }

    public String getBoxTrayColor() {
        return boxTrayColor;
    }

    public void setBoxTrayColor(String boxTrayColor) {
        this.boxTrayColor = boxTrayColor;
    }

    public String getArmColor() {
        return armColor;
    }

    public void setArmColor(String armColor) {
        this.armColor = armColor;
    }

    public String getFinishOptions() {
        return finishOptions;
    }

    public void setFinishOptions(String finishOptions) {
        this.finishOptions = finishOptions;
    }

    public String getRepresentativeImage() {
        return representativeImage;
    }

    public void setRepresentativeImage(String representativeImage) {
        this.representativeImage = representativeImage;
    }

    public String getFunctionalCategory() {
        return functionalCategory;
    }

    public void setFunctionalCategory(String functionalCategory) {
        this.functionalCategory = functionalCategory;
    }

    public String getUnconfiguredProductName() {
        return unconfiguredProductName;
    }

    public void setUnconfiguredProductName(String unconfiguredProductName) {
        this.unconfiguredProductName = unconfiguredProductName;
    }

    public String getConfiguredProductName() {
        return configuredProductName;
    }

    public void setConfiguredProductName(String configuredProductName) {
        this.configuredProductName = configuredProductName;
    }

    public String getAccessories() {
        return accessories;
    }

    public void setAccessories(String accessories) {
        this.accessories = accessories;
    }

    public Object getAttribute(String jsonProperty) {
        Field[] fields = BaseProduct.class.getDeclaredFields();
        for (Field field : fields) {
            if (field.isAnnotationPresent(JsonProperty.class)) {
                String annotationValue = field.getAnnotation(JsonProperty.class).value();
                if (annotationValue.equalsIgnoreCase(jsonProperty)) try {
                    return field.get(this);
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        }
        return "";
    }
}
