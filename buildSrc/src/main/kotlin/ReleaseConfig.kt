/**
 * @author nitishbhatt
 */

object ReleaseConfig {

    const val major = 0
    const val minor = 0
    const val patch = 1

    val appVersionName = getVersionName()

    val appVersionCode = major * 10000 + minor * 1000 + patch * 100

    private fun getVersionName() = "$major.$minor.$patch"
}
