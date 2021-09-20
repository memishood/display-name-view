[![License](https://img.shields.io/badge/License-MIT-yellow.svg)](https://raw.githubusercontent.com/memishood/display-name-view/master/LICENSE)
[![](https://jitpack.io/v/memishood/display-name-view.svg)](https://jitpack.io/#memishood/display-name-view)
<p>DisplayNameView generates an avatar from users name.</p>
<img src="https://github.com/memishood/display-name-view/blob/master/art/display_name_view.png">

## Setup
```
allprojects {
    repositories {
        ...
        maven { url 'https://jitpack.io' }
    }
}
```
```
dependencies {
    implementation "com.github.memishood:display-name-view:1.0.3"
}
```

## XML

```xml
<com.emrememis.library.DisplayNameView
        android:id="@+id/display_name_view"
        android:layout_width="120dp"
        android:layout_height="120dp"
        app:displayName="Johnny Bravo"
        app:textSize="31sp"
        app:textColor="@color/white"
        app:backgroundColor="@color/purple_200"
        app:strokeWidth="6dp"
        app:strokeColor="@color/black"/>
```
## Java

```java  
DisplayNameView displayNameView = findViewById(R.id.display_name_view);
// start the animation
displayNameView.startAnim();
// stop the animation
displayNameView.stopAnim();
```
-------------------
## Animation output
<img src="https://github.com/memishood/display-name-view/blob/master/art/display_name_view.gif">