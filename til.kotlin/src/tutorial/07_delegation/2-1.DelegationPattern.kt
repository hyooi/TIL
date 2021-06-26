package tutorial.`07_delegation`

interface SoundBehavior {
    fun makeSound()
}

class ScreamBehavior(val n:String): SoundBehavior {
    override fun makeSound() {
        println("${n.uppercase()} !!!")
    }
}

class RockAndRollBehavior(val n:String): SoundBehavior {
    override fun makeSound() {
        println("I'm The King of Rock 'N' Roll: $n")
    }
}

class TomAraya(n:String): SoundBehavior by ScreamBehavior(n)

class ElvisPresly(n:String): SoundBehavior by RockAndRollBehavior(n)

fun main() {
    val tomAraya = TomAraya("Thrash Metal")
    tomAraya.makeSound();

    val elvisPresly = ElvisPresly("Dancin' to the Jailhouse  Rock.")
    elvisPresly.makeSound();
}