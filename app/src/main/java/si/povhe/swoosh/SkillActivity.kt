package si.povhe.swoosh

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_skill.*

class SkillActivity : BaseActivity() {
    var skill=""
    var league = ""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_skill)
        league = intent.getStringExtra(EXTRA_LEAGUE)
        println(league)

        beginnerBtn.setOnClickListener {
            ballerBtn.isChecked=false
            skill="beginner"

            if (!beginnerBtn.isChecked){
                skill=""
            }
        }
        ballerBtn.setOnClickListener {
            beginnerBtn.isChecked=false
            skill="baller"

            if (!ballerBtn.isChecked){
                skill=""
            }
        }

        finishBtn.setOnClickListener {
            if(skill!=""){
                val searchIntent = Intent(this, SearchActivity::class.java)
                searchIntent.putExtra(EXTRA_LEAGUE, league)
                searchIntent.putExtra(EXTRA_SKILL, skill)
                startActivity(searchIntent)
            } else {
                Toast.makeText(this, "Prosim izberi težavnost.", Toast.LENGTH_SHORT).show()
            }

        }

    }
}
