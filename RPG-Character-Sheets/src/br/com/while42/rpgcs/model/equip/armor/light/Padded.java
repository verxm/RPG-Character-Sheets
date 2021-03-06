package br.com.while42.rpgcs.model.equip.armor.light;

import br.com.while42.rpgcs.R;
import br.com.while42.rpgcs.model.equip.armor.Armor;
import br.com.while42.rpgcs.model.equip.armor.BasicArmor;

public class Padded extends AbstractLightArmor implements Armor {
	private static final long serialVersionUID = 1L;

	private static final BasicArmor armor;
	static {
		armor = new BasicArmor(R.string.armor_light_padded);
		armor.setCost(5L);
		armor.setArmorBonus(1);
		armor.setMaximumDexBonus(8);
		armor.setArmorCheckPenalty(0);
		armor.setArcaneSpellFailureChance(5);
		armor.setSpeed(30);
		armor.setWeight(5.0);
	}
	
	public Padded() {
		super(armor);
	}

}
