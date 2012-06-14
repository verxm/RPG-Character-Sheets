package br.com.while42.rpgcs.model.equip.armor.heavy;

import br.com.while42.rpgcs.R;
import br.com.while42.rpgcs.model.equip.armor.Armor;
import br.com.while42.rpgcs.model.equip.armor.BasicArmor;

public class FullPlate extends AbstractHeavyArmor implements Armor {
	private static final long serialVersionUID = 1L;

	private static final BasicArmor armor;
	static {
		armor = new BasicArmor(R.string.armor_heavy_full_plate);
		armor.setCost(1500L);
		armor.setArmorBonus(8);
		armor.setMaximumDexBonus(1);
		armor.setArmorCheckPenalty(-6);
		armor.setArcaneSpellFailureChance(35);
		armor.setSpeed(20);
		armor.setWeight(25.0);
	}
	
	public FullPlate() {
		super(armor);
	}

}
