package br.com.while42.rpgcs.model.equip.weapons.simple.ranged;

import br.com.while42.rpgcs.R;
import br.com.while42.rpgcs.model.HitDice;
import br.com.while42.rpgcs.model.HitDiceType;
import br.com.while42.rpgcs.model.character.TypeMunition;
import br.com.while42.rpgcs.model.equip.weapons.BasicWeapon;
import br.com.while42.rpgcs.model.equip.weapons.SizeWeapon;
import br.com.while42.rpgcs.model.equip.weapons.TypeWeapon;

public class Sling extends AbstractSimpleRangedWeapon {
	private static final long serialVersionUID = 1L;
	
	private static BasicWeapon base;

	static {
		base = new BasicWeapon(R.string.weapon_simple_sling, R.drawable.weapon_axe);
		base.setCost(0L);
		base.setCritical(2);
		base.setRangeIncrement(15);
		base.setWeight(0d);
		
		base.addDamage(SizeWeapon.SMALL, new HitDice(HitDiceType.d3));
		base.addDamage(SizeWeapon.MEDIUM, new HitDice(HitDiceType.d4));
		
		base.addType(TypeWeapon.BLUDGEONING);
	}
	
	public Sling() {
		super(base, TypeMunition.BULLETS);
	}
}
