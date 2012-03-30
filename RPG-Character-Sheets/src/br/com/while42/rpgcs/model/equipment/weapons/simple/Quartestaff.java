package br.com.while42.rpgcs.model.equipment.weapons.simple;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import br.com.while42.rpgcs.R;
import br.com.while42.rpgcs.model.HitDice;
import br.com.while42.rpgcs.model.HitDiceType;
import br.com.while42.rpgcs.model.equipment.weapons.SizeWeapon;
import br.com.while42.rpgcs.model.equipment.weapons.TypeWeapon;

public class Quartestaff extends AbstractSimpleWeapon {

	private static final int nameCode = R.string.weapon_simple_quartestaff;
	private static final int cost = 0;
	private static final Map<SizeWeapon, HitDice> damage = new HashMap<SizeWeapon, HitDice>();	
	private static final int critical = 2;
	private static final int rangeIncrement = 0;
	private static final double weight = 2;
	private static final Set<TypeWeapon> types = new HashSet<TypeWeapon>();
	
	static {
		damage.put(SizeWeapon.SMALL, new HitDice(HitDiceType.d4));
		damage.put(SizeWeapon.MEDIUM, new HitDice(HitDiceType.d6));
		
		types.add(TypeWeapon.BLUDGEONING);
	}
	
	
	@Override
	public int getCodeName() {
		return nameCode;
	}
	
	@Override
	public int getCost() {
		return cost;
	}

	@Override
	public HitDice getDamage() {
		return getDamage(SizeWeapon.MEDIUM);
	}

	@Override
	public HitDice getDamage(SizeWeapon size) {
		return damage.get(size);
	}

	@Override
	public int getCritical() {
		return critical;
	}

	@Override
	public int getRangeIncrement() {
		return rangeIncrement;
	}

	@Override
	public double getWeight() {
		return weight;
	}

	@Override
	public Set<TypeWeapon> getType() {
		return Collections.unmodifiableSet(types);
	}

}