package br.com.while42.rpgcs.model.equip.weapons;

import java.util.List;
import java.util.Set;

import br.com.while42.rpgcs.model.HitDice;
import br.com.while42.rpgcs.model.TypeCode;
import br.com.while42.rpgcs.model.equip.Equipment;

public interface Weapon extends Equipment, TypeCode {
	
	public List<HitDice> getDamage();
	public List<HitDice> getDamage(SizeWeapon size);
	public int getCritical();
	public int getRangeIncrement();
	public CategorieWeapon getCategorie();
	public CategorieUsefulnessWeapon getCategorieUsefulness();
	public CategorieEncumbranceWeapon getCategorieEncumbrance();
	public Set<TypeWeapon> getType();
}
