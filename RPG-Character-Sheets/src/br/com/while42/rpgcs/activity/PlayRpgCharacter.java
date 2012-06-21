package br.com.while42.rpgcs.activity;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import br.com.while42.rpgcs.R;
import br.com.while42.rpgcs.model.character.Abilities;
import br.com.while42.rpgcs.model.character.Attributes;
import br.com.while42.rpgcs.model.character.Defences;
import br.com.while42.rpgcs.model.character.Languages;
import br.com.while42.rpgcs.model.character.RpgCharacter;
import br.com.while42.rpgcs.model.character.SavingThrows;
import br.com.while42.rpgcs.model.character.Skill;
import br.com.while42.rpgcs.model.character.Skills;
import br.com.while42.rpgcs.model.character.attributes.TypeAbilities;
import br.com.while42.rpgcs.model.character.attributes.TypeRpgLanguage;
import br.com.while42.rpgcs.model.character.attributes.TypeRpgSkill;
import br.com.while42.rpgcs.model.classes.AbstractRpgClass;

public class PlayRpgCharacter extends Activity {
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		setContentView(R.layout.play_character);

		Bundle bn = new Bundle();
        bn = getIntent().getExtras();
        RpgCharacter rpgCharacter = (RpgCharacter) bn.getSerializable(RpgCharacter.class.getName());
        
        Log.d("ID: ", rpgCharacter.getId().toString());
		
		TextView tvName = (TextView) findViewById(R.id_play.textview_name);
		TextView tvGenderRace = (TextView) findViewById(R.id_play.textview_gender_race);
		TextView tvAlignment = (TextView) findViewById(R.id_play.textview_alignment);
		TextView tvClassesLevel = (TextView) findViewById(R.id_play.textview_classes_level);
		TextView tvExperience = (TextView) findViewById(R.id_play.textview_experience);
		
		TextView tvStrength = (TextView) findViewById(R.id_play.textview_strength);
		TextView tvStrengthModifier = (TextView) findViewById(R.id_play.textview_strength_modifier);
		TextView tvConstitution = (TextView) findViewById(R.id_play.textview_constitution);
		TextView tvConstitutionModifier = (TextView) findViewById(R.id_play.textview_constitution_modifier);
		TextView tvWisdom = (TextView) findViewById(R.id_play.textview_wisdom);
		TextView tvWisdomModifier = (TextView) findViewById(R.id_play.textview_wisdom_modifier);
		TextView tvCharisma = (TextView) findViewById(R.id_play.textview_charisma);
		TextView tvCharismaModifier = (TextView) findViewById(R.id_play.textview_charisma_modifier);
		TextView tvDexterity = (TextView) findViewById(R.id_play.textview_dexterity);
		TextView tvDexterityModifier = (TextView) findViewById(R.id_play.textview_dexterity_modifier);
		TextView tvIntelligence = (TextView) findViewById(R.id_play.textview_intelligence);
		TextView tvIntelligenceModifier = (TextView) findViewById(R.id_play.textview_intelligence_modifier);
		
		TextView tvArmorClass = (TextView) findViewById(R.id_play.textview_armor_class);
		
		TextView tvFortitude = (TextView) findViewById(R.id_play.textview_fortitude);
		TextView tvReflex = (TextView) findViewById(R.id_play.textview_reflex);
		TextView tvThrowsWill = (TextView) findViewById(R.id_play.textview_will);
		
		ListView lvLanguages = (ListView) findViewById(R.id_play.listview_languages);
		ListView lvSkills = (ListView) findViewById(R.id_play.listview_skills);
					
		TextView tvReligion = (TextView) findViewById(R.id_play.textview_religion);
		TextView tvVision = (TextView) findViewById(R.id_play.textview_vision);
		
		// ---
		
		tvName.setText(rpgCharacter.getName());
		
		Attributes attr = rpgCharacter.getAttributes();
		
		StringBuilder sbGenderRace = new StringBuilder();
		sbGenderRace.append(getString(attr.getGender().getCodeName()));
		sbGenderRace.append(" ");
		sbGenderRace.append(getString(attr.getRace().getCodeName()));
		
		tvGenderRace.setText(sbGenderRace.toString());
		
		tvAlignment.setText(getString(attr.getAlignment().getCodeName()));
		
		StringBuilder sbClassLevel = new StringBuilder();
		for (AbstractRpgClass clazz : rpgCharacter.getRpgClasses().getAll()) {
			if (sbClassLevel.length() > 0) {
				sbClassLevel.append(" / ");
			}
			sbClassLevel.append(getString(clazz.getCodeName()));
			sbClassLevel.append(" (");
			sbClassLevel.append(clazz.getClassLevel().toString());
			sbClassLevel.append(")");
		}
		
		tvClassesLevel.setText(sbClassLevel.toString()); 
		
		tvExperience.setText(rpgCharacter.getRpgClasses().getExperience().toString());
		
		NumberFormat fmt = new DecimalFormat("+#;-#");
		
		Abilities abilities = rpgCharacter.getAbilities();
		
		String strength = abilities.getStrength().toString();
		String strengthMod = fmt.format(abilities.getStrengthModifier());
		String constitution = abilities.getConstitution().toString();
		String constitutionMod = fmt.format(abilities.getConstitutionModifier());
		String wisdom = abilities.getWisdom().toString();
		String wisdomMod = fmt.format(abilities.getWisdomModifier());
		String charisma = abilities.getCharisma().toString();
		String charismaMod = fmt.format(abilities.getCharismaModifier());
		String dexterity = abilities.getDexterity().toString();
		String dexterityMod = fmt.format(abilities.getDexterityModifier());
		String intelligence = abilities.getIntelligence().toString();
		String intelligenceMod = fmt.format(abilities.getIntelligenceModifier());
		
		tvStrength.setText(strength);
		tvStrengthModifier.setText(strengthMod);
		
		tvConstitution.setText(constitution);
		tvConstitutionModifier.setText(constitutionMod);
		
		tvWisdom.setText(wisdom);
		tvWisdomModifier.setText(wisdomMod);
		
		tvCharisma.setText(charisma);
		tvCharismaModifier.setText(charismaMod);
		
		tvDexterity.setText(dexterity);
		tvDexterityModifier.setText(dexterityMod);
		
		tvIntelligence.setText(intelligence);
		tvIntelligenceModifier.setText(intelligenceMod);
		
		Defences defences = rpgCharacter.getDefences();
		
		tvArmorClass.setText(defences.getArmorClass().toString());
		
		SavingThrows savingThrows = rpgCharacter.getSavingThrows();
		
		tvFortitude.setText(savingThrows.getFortitude().toString());
		tvReflex.setText(savingThrows.getReflex().toString());
		tvThrowsWill.setText(savingThrows.getThrowsWill().toString());
		
		Languages languages = rpgCharacter.getLanguages();
		{
			String[] lgs = new String[languages.getAll().size()];
			int i = 0;
			for (TypeRpgLanguage type: languages.getAll()) {
				lgs[i++] = getString(type.getCodeName());
			}
		
			Arrays.sort(lgs);
		
			ArrayAdapter<String> adapterLanguages = new ArrayAdapter<String>(this,
					R.layout.list_languages, android.R.id.text1, lgs);
		
			lvLanguages.setAdapter(adapterLanguages);
		}
		
		Skills skills = rpgCharacter.getSkills();
		{
			ArrayList<HashMap<String, String>> sklls = new ArrayList<HashMap<String, String>>();
			for (Skill skill: skills.getAll()) {
				HashMap<String, String> map = new HashMap<String, String>();
				TypeRpgSkill type = skill.getType();
				
				map.put("name", getString(type.getCodeName()));
				map.put("modifier", "(" + fmt.format(skill.getModifier()) + ")");
				
				TypeAbilities ability = type.getAbility();
				int code = (ability != null) ? ability.getCodeName() : R.string.ability_none;
				map.put("ability", getString(code));

				sklls.add(map);
			}
			
			Comparator<Map<String, String>> mapComparator = new Comparator<Map<String, String>>() {
				@Override
				public int compare(Map<String, String> m1, Map<String, String> m2) {
			        return m1.get("name").compareTo(m2.get("name"));
			    }
			};
			
			Collections.sort(sklls, mapComparator);

			SimpleAdapter adapterSkills = new SimpleAdapter(this, sklls, R.layout.list_skills,
			            new String[] {"name", "modifier", "ability"}, new int[] {R.id.name, R.id.modifier, R.id.ability});
			
			lvSkills.setAdapter(adapterSkills);
		}
			
		String religion = getString(attr.getReligion().getCodeName());
		tvReligion.setText(religion);
		
		String vision = getString(attr.getVision().getCodeName());
		tvVision.setText(vision);
	}

}
