plugins {
    alias(libs.plugins.android.application)
}

android {
    namespace = "br.edu.uniceplac.vitorias"
    compileSdk {
        version = release(37)

        buildFeatures {
            viewBinding = true
        }
    }

    defaultConfig {
        applicationId = "br.edu.uniceplac.vitorias"
        minSdk = 24
        targetSdk = 37
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            optimization {
                enable = false
            }
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
}

dependencies {
    // Carrossel de vídeos
    implementation("androidx.viewpager2:viewpager2:1.1.0")
    // Carrega imagens da internet (miniaturas do YouTube)
    implementation("io.coil-kt:coil:2.7.0")

    implementation(libs.androidx.activity.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.androidx.constraintlayout)
    implementation(libs.androidx.core.ktx)
    implementation(libs.material)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(libs.androidx.junit)
}