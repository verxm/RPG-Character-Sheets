package br.com.while42.rpgcs.model.equip.weapons.martial.ranged;

import br.com.while42.rpgcs.R;
import br.com.while42.rpgcs.model.HitDice;
import br.com.while42.rpgcs.model.HitDiceType;
import br.com.while42.rpgcs.model.character.TypeMunition;
import br.com.while42.rpgcs.model.equip.weapons.BasicWeapon;
import br.com.while42.rpgcs.model.equip.weapons.SizeWeapon;
import br.com.while42.rpgcs.model.equip.weapons.TypeWeapon;

public class ShortbowComposite extends AbstractMartialRangedWeapon {
	private static final long serialVersionUID = 1L;
	
	private static BasicWeapon base;

	static {
		base = new BasicWeapon(R.string.weapon_martial_shortbow_composite);
		base.setCost(75L);
		base.setCritical(3);
		base.setRangeIncrement(21);
		base.setWeight(1d);
		
		base.addDamage(SizeWeapon.SMALL, new HitDice(HitDiceType.d4));
		base.addDamage(SizeWeapon.MEDIUM, new HitDice(HitDiceType.d6));
		
		base.addType(TypeWeapon.PIERCING);
	}
	
	public ShortbowComposite() {
		super(base, TypeMunition.ARROWS);
	}
}
