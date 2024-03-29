plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id("com.google.devtools.ksp")
}

android {
    namespace = "corsac.software.meutreino"
    compileSdk = 34

    defaultConfig {
        applicationId = "corsac.software.meutreino"
        minSdk = 29
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
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    kotlinOptions {
        jvmTarget = "17"
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.5.3"
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

object Versions {
    val Koin = "3.5.3"
    val KoinCompose = "3.5.3"
    val Room = "2.6.1"
    val Voyager = "1.0.0"
}

dependencies {
    implementation("androidx.core:core-ktx:1.12.0")
    implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.7.0")
    implementation("androidx.activity:activity-compose:1.8.2")
    implementation(platform("androidx.compose:compose-bom:2023.03.00"))
    implementation("androidx.compose.ui:ui")
    implementation("androidx.compose.ui:ui-graphics")
    implementation("androidx.compose.ui:ui-tooling-preview")
    implementation("androidx.compose.material3:material3")
    implementation("androidx.room:room-runtime:${Versions.Room}")
    implementation("androidx.room:room-ktx:${Versions.Room}")

    implementation("cafe.adriel.voyager:voyager-navigator:${Versions.Voyager}")
    implementation("cafe.adriel.voyager:voyager-screenmodel:${Versions.Voyager}")
    implementation("cafe.adriel.voyager:voyager-bottom-sheet-navigator:${Versions.Voyager}")
    implementation("cafe.adriel.voyager:voyager-tab-navigator:${Versions.Voyager}")
    implementation("cafe.adriel.voyager:voyager-transitions:${Versions.Voyager}")
    implementation("cafe.adriel.voyager:voyager-koin:${Versions.Voyager}")

    implementation("io.insert-koin:koin-androidx-compose:${Versions.KoinCompose}")
    compileOnly("io.insert-koin:koin-core:${Versions.Koin}")

    ksp("androidx.room:room-compiler:${Versions.Room}")
    annotationProcessor("androidx.room:room-compiler:${Versions.Room}")

    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
    androidTestImplementation(platform("androidx.compose:compose-bom:2023.03.00"))
    androidTestImplementation("androidx.compose.ui:ui-test-junit4")
    debugImplementation("androidx.compose.ui:ui-tooling")
    debugImplementation("androidx.compose.ui:ui-test-manifest")
}