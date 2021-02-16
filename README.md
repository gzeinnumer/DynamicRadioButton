<h1 align="center">
<img src="https://github.com/gzeinnumer/DynamicRadioButton/blob/master/preview/example1.jpg" width="300"/> <img src="https://github.com/gzeinnumer/DynamicRadioButton/blob/master/preview/example3.jpg" width="300"/>

</h1>

<h1 align="center">
  DynamicRadioButton - Easy RadioButton Dynamic
</h1>

<div align="center">
    <a><img src="https://img.shields.io/badge/Version-2.0.0-brightgreen.svg?style=flat"></a>
    <a><img src="https://img.shields.io/badge/ID-gzeinnumer-blue.svg?style=flat"></a>
    <a><img src="https://img.shields.io/badge/Java-Suport-green?logo=java&style=flat"></a>
    <a><img src="https://img.shields.io/badge/Kotlin-Suport-green?logo=kotlin&style=flat"></a>
    <a href="https://github.com/gzeinnumer"><img src="https://img.shields.io/github/followers/gzeinnumer?label=follow&style=social"></a>
    <br>
    <p>Simple way to use Dynamic RadioButton</p>
</div>

---
# Content List
* [Download](#download)
* [Feature List](#feature-list)
* [Usage](#usage)
* [Example Code/App](#example-codeapp)
* [Version](#version)
* [Contribution](#contribution)

---
# Download
Add maven `jitpack.io` and `dependencies` in `build.gradle (Project)` :
```gradle
// build.gradle project
allprojects {
  repositories {
    ...
    maven { url 'https://jitpack.io' }
  }
}

// build.gradle app/module
dependencies {
  ...
  implementation 'com.github.gzeinnumer:DynamicRadioButton:version'
}
```

---
# Feature List
- [x] [Dynamic RadioButton](#DynamicRadioButton)

---
# Usage

### DynamicRadioButton

- Widget on `xml`
```xml
<com.gzeinnumer.dr.DynamicRadioButton
    android:id="@+id/dr"
    android:layout_width="match_parent"
    android:layout_height="wrap_content"/>
```

if you want to custom your `RadioButton` use `app:style="@style/radioButtonStyle"` on view, and make style on your `res->value->style.xml`
```xml
<resources xmlns:tools="http://schemas.android.com/tools">

    <style name="radioButtonStyle" parent="Base.Theme.AppCompat">
        <item name="android:textColor">#FFE500</item>
    </style>
</resources>
```
```xml
<com.gzeinnumer.dr.DynamicRadioButton
    ...
    app:orientation="horizontal"
    app:style="@style/radioButtonStyle"/>
```

#
- **Content Item** there is 2 type list that you can sent to this `RadioButton`.

**Type 1**
```java
DynamicRadioButton dynamicRadioButton = findViewById(R.id.dr);

ArrayList<String> listString = new ArrayList<String>();
listString.add("Satu");
listString.add("Dua");
listString.add("Tiga");
listString.add("Empat");

dynamicRadioButton.setItemList(listString).setOnCheckedChangeListener(new DynamicRadioButton.OnCheckedChangeListener<String>() {
    @Override
    public void onCheckedChanged(String item) {
        Log.d(TAG, "onCheckedChanged: "+item);
    }
});
```

**Type 2** for this type you should override function `toString()` in your `model pojo`
```java
public class ExampleModel {

    private int id;
    private String name;
    private String address;

    //constructor

    //getter
    //setter

    @Override
    public String toString() {
        return "ExampleModel{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
```
Use your own model. And dont forget to declare your `model pojo` in `onCallBack`. Example `DynamicRadioButton.OnCheckedChangeListener<ExampleModel>`
```java
DynamicRadioButton dynamicRadioButton = findViewById(R.id.dr);

ArrayList<ExampleModel> listObject = new ArrayList<>();
listObject.add(new ExampleModel(1, "Zein", "Balbar"));
listObject.add(new ExampleModel(2, "Zein2", "Balbar2"));
listObject.add(new ExampleModel(3, "Zein3", "Balbar3"));
listObject.add(new ExampleModel(4, "Zein4", "Balbar4"));

dynamicRadioButton.setItemList(listObject).setOnCheckedChangeListener(new DynamicRadioButton.OnCheckedChangeListener<ExampleModel>() {
    @Override
    public void onCheckedChanged(ExampleModel item) {
        Log.d(TAG, "onCheckedChanged: "+item.toString());
    }
});
```

#
**Preview** :

| <img src="https://github.com/gzeinnumer/DynamicRadioButton/blob/master/preview/example1.jpg"/>| <img src="https://github.com/gzeinnumer/DynamicRadioButton/blob/master/preview/example3.jpg"/> |
|:---|:---|
| Preview `Single Object`| Preview `Model Pojo`|

| <img src="https://github.com/gzeinnumer/DynamicRadioButton/blob/master/preview/example2.jpg"/> |
|:---|
| Output data `Single Object`|

| <img src="https://github.com/gzeinnumer/DynamicRadioButton/blob/master/preview/example4.jpg"/> |
|:---|
|  Output data `Model Pojo`|

---
# Example Code/App

**FullCode [MainActivity](https://github.com/gzeinnumer/DynamicRadioButton/blob/master/app/src/main/java/com/gzeinnumer/dynamicradiobutton/MainActivity.java) & [ExampleModel](https://github.com/gzeinnumer/DynamicRadioButton/blob/master/app/src/main/java/com/gzeinnumer/dynamicradiobutton/ExampleModel.java) & [XML](https://github.com/gzeinnumer/DynamicRadioButton/blob/master/app/src/main/res/layout/activity_main.xml)**

[Sample Code And App](https://github.com/gzeinnumer/MyLibDynamicRadioButtonExample)

---
# Version
- **1.0.0**
  - First Release
- **2.0.0**
  - Support SDK 16

---
# Contribution
You can sent your constibution to `branch` `open-pull`.

---

```
Copyright 2020 M. Fadli Zein
```
