package si.povhe.swoosh

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_skill.*
import si.povhe.swoosh.Model.Player

class SkillActivity : BaseActivity() {
    lateinit var player: Player

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_skill)
        player = intent.getParcelableExtra(EXTRA_PLAYER)

        beginnerBtn.setOnClickListener {
            ballerBtn.isChecked=false
            player.skill="beginner"

            if (!beginnerBtn.isChecked){
                player.skill=""
            }
        }
        ballerBtn.setOnClickListener {
            beginnerBtn.isChecked=false
            player.skill="baller"

            if (!ballerBtn.isChecked){
                player.skill=""
            }
        }

        finishBtn.setOnClickListener {
            if(player.skill!=""){
                val searchIntent = Intent(this, SearchActivity::class.java)
                searchIntent.putExtra(EXTRA_PLAYER, player)
                startActivity(searchIntent)
            } else {
                Toast.makeText(this, "Prosim izberi težavnost.", Toast.LENGTH_SHORT).show()
            }

        }

    }
}
