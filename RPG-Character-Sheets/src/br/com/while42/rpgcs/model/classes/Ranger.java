package br.com.while42.rpgcs.model.classes;

import br.com.while42.rpgcs.model.HitDiceType;
import br.com.while42.rpgcs.model.character.attributes.TypeRpgClass;
import br.com.while42.rpgcs.model.classes.bonuses.BaseAttackBonuses;
import br.com.while42.rpgcs.model.classes.bonuses.BaseSaveBonuses;

public class Ranger extends AbstractClass implements CharacterClass, SpellsPerDay {
	
	@Override
	public HitDiceType getHitDice() {		
		return HitDiceType.d8;
	}
	
	@Override
	public TypeRpgClass getClassType() {
		return TypeRpgClass.RANGER;
	}

	@Override
	public int getBaseAttackBonus(int classLevel) {
		return new BaseAttackBonuses().getGood(classLevel);
	}

	@Override
	public int getFortSave(int classLevel) {
		return new BaseSaveBonuses().getGood(classLevel);
	}

	@Override
	public int getRefSave(int classLevel) {
		return new BaseSaveBonuses().getGood(classLevel);
	}

	@Override
	public int getWillSave(int classLevel) {
		return new BaseSaveBonuses().getPoor(classLevel);
	}

	@Override
	public int capacitySpellsPerDay(int level, int spellLevel) {
		// TODO Auto-generated method stub
		return 0;
	}
}