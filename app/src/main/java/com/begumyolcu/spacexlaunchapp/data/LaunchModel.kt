package com.begumyolcu.spacexlaunchapp.data

data class LaunchModel(
    val `data`: Data
)

data class Data(
    val launchesPast: List<LaunchesPast>
)

data class LaunchesPast(
    val launch_date_local: String,
    val launch_site: LaunchSite,
    val links: Links,
    val mission_name: String,
    val rocket: Rocket,
    val ships: List<Ship>
)

data class LaunchSite(
    val site_name_long: String
)

data class Links(
    val article_link: String?,
    val video_link: String
)

data class Rocket(
    val first_stage: FirstStage,
    val rocket_name: String,
    val second_stage: SecondStage
)

data class FirstStage(
    val cores: List<Core>
)

data class Core(
    val core: CoreX,
    val flight: Int
)

data class CoreX(
    val reuse_count: Int,
    val status: String?
)

data class SecondStage(
    val payloads: List<Payload>
)

data class Payload(
    val payload_mass_kg: Int?,
    val payload_mass_lbs: Double?,
    val payload_type: String
)

data class Ship(
    val home_port: String,
    val image: String,
    val name: String
)
