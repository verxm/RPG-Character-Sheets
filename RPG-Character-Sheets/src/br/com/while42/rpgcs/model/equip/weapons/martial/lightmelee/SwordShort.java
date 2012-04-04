package br.com.while42.rpgcs.model.equip.weapons.martial.lightmelee;

import br.com.while42.rpgcs.R;
import br.com.while42.rpgcs.model.HitDice;
import br.com.while42.rpgcs.model.HitDiceType;
import br.com.while42.rpgcs.model.equip.weapons.BasicWeapon;
import br.com.while42.rpgcs.model.equip.weapons.SizeWeapon;
import br.com.while42.rpgcs.model.equip.weapons.TypeWeapon;

public class SwordShort extends AbstractMartialLightMeleeWeapon {
	
	private static BasicWeapon base;

	static {
		base = new BasicWeapon(R.string.weapon_martial_sword_short);
		base.setCost(10);
		base.setCritical(2);
		base.setRangeIncrement(0);
		base.setWeight(1);
		
		base.addDamage(SizeWeapon.SMALL, new HitDice(HitDiceType.d4));
		base.addDamage(SizeWeapon.MEDIUM, new HitDice(HitDiceType.d6));
		
		base.addType(TypeWeapon.PIERCING);
	}
	
	public SwordShort() {
		super(base);
	}
}