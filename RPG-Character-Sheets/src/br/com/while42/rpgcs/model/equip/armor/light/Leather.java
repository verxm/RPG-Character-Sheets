package br.com.while42.rpgcs.model.equip.armor.light;

import br.com.while42.rpgcs.R;
import br.com.while42.rpgcs.model.equip.armor.Armor;
import br.com.while42.rpgcs.model.equip.armor.BasicArmor;

public class Leather extends AbstractLightArmor implements Armor {
	private static final long serialVersionUID = 1L;

	private static final BasicArmor armor;
	static {
		armor = new BasicArmor(R.string.armor_light_leather);
		armor.setCost(10L);
		armor.setArmorBonus(2);
		armor.setMaximumDexBonus(6);
		armor.setArmorCheckPenalty(0);
		armor.setArcaneSpellFailureChance(10);
		armor.setSpeed(30);
		armor.setWeight(7.5);
	}
	
	public Leather() {
		super(armor);
	}

}
