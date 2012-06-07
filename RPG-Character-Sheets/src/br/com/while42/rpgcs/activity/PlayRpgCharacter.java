package br.com.while42.rpgcs.activity;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import br.com.while42.rpgcs.R;
import br.com.while42.rpgcs.model.character.RpgCharacter;
import br.com.while42.rpgcs.persist.DataManager;

public class PlayRpgCharacter extends Activity {

	@Override
	protected void onResume() {
		super.onResume();
	}

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		setContentView(R.layout.play_character);
		
		Long id = getIntent().getLongExtra("id", 0L);
		
		DataManager manager = new DataManager(getApplicationContext());
		
		Log.d("ID: ", id.toString());
		
		RpgCharacter rpgCharacter = manager.retrieveRpgCharacter(id);
		
		TextView name = (TextView) findViewById(R.id_play.textview_name);
		TextView gender_race_class = (TextView) findViewById(R.id_play.textview_gender_race_class);
		TextView alignment = (TextView) findViewById(R.id_play.textview_alignment);
		TextView experience = (TextView) findViewById(R.id_play.textview_experience);
		
		TextView strength = (TextView) findViewById(R.id_play.textview_strength);
		TextView strength_modifier = (TextView) findViewById(R.id_play.textview_strength_modifier);
		TextView constitution = (TextView) findViewById(R.id_play.textview_constitution);
		TextView constitution_modifier = (TextView) findViewById(R.id_play.textview_constitution_modifier);
		TextView wisdom = (TextView) findViewById(R.id_play.textview_wisdom);
		TextView wisdom_modifier = (TextView) findViewById(R.id_play.textview_wisdom_modifier);
		TextView charisma = (TextView) findViewById(R.id_play.textview_charisma);
		TextView charisma_modifier = (TextView) findViewById(R.id_play.textview_charisma_modifier);
		TextView dexterity = (TextView) findViewById(R.id_play.textview_dexterity);
		TextView dexterity_modifier = (TextView) findViewById(R.id_play.textview_dexterity_modifier);
		TextView intelligence = (TextView) findViewById(R.id_play.textview_intelligence);
		TextView intelligence_modifier = (TextView) findViewById(R.id_play.textview_intelligence_modifier);
		
		TextView armorClass = (TextView) findViewById(R.id_play.textview_armor_class);
		
		TextView fortitude = (TextView) findViewById(R.id_play.textview_fortitude);
		TextView reflex = (TextView) findViewById(R.id_play.textview_reflex);
		TextView will = (TextView) findViewById(R.id_play.textview_will);
					
		name.setText(rpgCharacter.getName());
		
		StringBuilder sbGenderRaceClass = new StringBuilder();
		sbGenderRaceClass.append(getString(rpgCharacter.getGender().getCodeName())).append(" ");
		sbGenderRaceClass.append(getString(rpgCharacter.getRace().getCodeName())).append(" ");
		
		if (!rpgCharacter.getRpgClasses().isEmpty()) {
			sbGenderRaceClass.append(getString(rpgCharacter.getRpgClasses().get(0).getCodeName()));
		}
		
		gender_race_class.setText(sbGenderRaceClass.toString());
		
		alignment.setText(getString(rpgCharacter.getAlignment().getCodeName()));
		experience.setText(rpgCharacter.getExperience().toString());
		
		strength.setText("15");
		strength_modifier.setText("+2");
		
		constitution.setText("13");
		constitution_modifier.setText("+1");
		
		wisdom.setText("10");
		wisdom_modifier.setText("+0");
		
		charisma.setText("10");
		charisma_modifier.setText("+0");
		
		dexterity.setText("10");
		dexterity_modifier.setText("+0");
		
		intelligence.setText("10");
		intelligence_modifier.setText("+0");
		
		armorClass.setText("25");
		fortitude.setText("19");
		reflex.setText("23");
		will.setText("25");
		
		
	}

}
