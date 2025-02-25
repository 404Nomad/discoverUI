On crée notre premier DiscoverUI

on nettoie activity_main.xml

```xml

<?xml version="1.0" encoding="utf-8"?>
<!-- Ici on clear et on reassigne notre layout, on ajoute android et tools-->
<!-- mettre en place un wrapper(android:orientation) -->
<LinearLayout
    xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:tools="http://schemas.android.com/tools"

    android:layout_width="match_parent"
    android:layout_height="match_parent"

    android:orientation="vertical"

    >

</LinearLayout>

```

MainActiviti.kt

```kotlin
package com.cfa.discoverui

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    }
}
```

on ajoute nos elements dans activity_main.xml

```xml
<?xml version="1.0" encoding="utf-8"?>
    <!-- Ici on clear et on reassigne notre layout, on ajoute android et tools-->
    <!-- mettre en place un wrapper(android:orientation) -->
<LinearLayout
xmlns:android="http://schemas.android.com/apk/res/android"
xmlns:tools="http://schemas.android.com/tools"

android:layout_width="match_parent"
android:layout_height="match_parent"

android:orientation="vertical"
    >

<!-- Ici on ajoute notre TextView -->
<!-- Adapter hauteur au contenu du text view-->
<TextView
    android:layout_width="match_parent"
    android:layout_height="wrap_content"
    android:text="Bienvenue dans mon premier projet Android/KOTLIN"
    android:layout_marginBottom="10sp"
    style="@style/titre"
    />

<TextView
    android:layout_width="match_parent"
    android:layout_height="wrap_content"
    android:text="Sous titre"
    style="@style/SousTitre"
    />

<!--Nouveau composant -->
<ImageView
    android:layout_width=""
    android:layout_height=""
    />

</LinearLayout>
```

on crée une nouvelle couleur et un nouveau style.xml

```xml
<?xml version="1.0" encoding="utf-8"?>
<resources>
    <!-- Style du titre-->
    <style name="titre">
        <item name="android:padding">5dp</item>
        <item name="android:textColor">@color/purple</item>
        <item name="android:textAlignment">center</item>
        <item name="android:textSize">36dp</item>
        <!-- de 100 a 900 pour le fontweight-->
        <item name="android:fontWeight">600</item>
    </style>

    <style name="SousTitre">
        <item name="android:textAlignment">center</item>
        <item name="android:textSize">24dp</item>
        <item name="android:textStyle">italic</item>
    </style>

</resources>
```

Dans activity_main.xml

on crée notre premiere image

```xml
<!--Nouveau composant -->
<ImageView
    android:layout_width="match_parent"
    android:layout_height="wrap_content"
    android:src="@mipmap/ic_launcher_round"
    />
```

on crée notre premier button