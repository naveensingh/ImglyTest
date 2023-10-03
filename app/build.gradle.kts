plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id("ly.img.android.sdk").version("10.7.2")
}

android {
    namespace = "com.naveensingh.imglytest"
    compileSdk = 33

    defaultConfig {
        applicationId = "com.naveensingh.imglytest"
        minSdk = 24
        targetSdk = 33
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
    }

    buildTypes {
        release {
            isMinifyEnabled = true
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
            signingConfig = signingConfigs.getByName("debug")
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    kotlinOptions {
        jvmTarget = JavaVersion.VERSION_17.toString()
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.4.3"
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {
    implementation("androidx.core:core-ktx:1.9.0")
    implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.6.2")
    implementation("androidx.activity:activity-compose:1.7.2")
    implementation(platform("androidx.compose:compose-bom:2023.03.00"))
    implementation("androidx.compose.ui:ui")
    implementation("androidx.compose.ui:ui-graphics")
    implementation("androidx.compose.ui:ui-tooling-preview")
    implementation("androidx.compose.material3:material3")
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
    androidTestImplementation(platform("androidx.compose:compose-bom:2023.03.00"))
    androidTestImplementation("androidx.compose.ui:ui-test-junit4")
    debugImplementation("androidx.compose.ui:ui-tooling")
    debugImplementation("androidx.compose.ui:ui-test-manifest")
}

imglyConfig {
    pesdk {
        enabled(true)
        licensePath(null)
    }

    vesdk {
        enabled(true)
        licensePath(null)
    }

    modules {
        include("ui:core")
        include("ui:text")
        include("ui:focus")
        include("ui:frame")
        include("ui:brush")
        include("ui:filter")
        include("ui:sticker")
        include("ui:overlay")
        include("ui:transform")
        include("ui:adjustment")
        include("ui:text-design")

        include("backend:serializer")
        include("backend:headless")
        include("backend:background-removal")
        include("backend:sticker-smart")

        include("assets:font-basic")
        include("assets:frame-basic")
        include("assets:filter-basic")
        include("assets:overlay-basic")
        include("assets:sticker-shapes")
        include("assets:sticker-emoticons")
    }
}