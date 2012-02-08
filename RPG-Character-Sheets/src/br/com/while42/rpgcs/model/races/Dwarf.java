package br.com.while42.rpgcs.model.races;

import br.com.while42.rpgcs.model.character.attributes.TypeRpgClass;

public class Dwarf extends AbstractRace {

	public static final int MIDDLE_AGE = 125; 
	public static final int OLD_AGE = 188;
	public static final int VENERABLE_AGE = 250;
	
	private static final int ADJUSTMENTS_OF_CONSTITUTION = +2;
	private static final int ADJUSTMENTS_OF_CHARISMA = -2;
	
	@Override
	public int getAdjustmentsOfConstitution() {
		return ADJUSTMENTS_OF_CONSTITUTION;
	}

	@Override
	public int getAdjustmentsOfCharisma() {
		return ADJUSTMENTS_OF_CHARISMA;
	}

	@Override
	public TypeRpgClass getFavoredClass() {
		return TypeRpgClass.FIGHTER;
	}

	@Override
	public int getMiddleAge() {
		return MIDDLE_AGE;
	}

	@Override
	public int getOldAge() {
		return OLD_AGE;
	}

	@Override
	public int getVenerableAge() {
		return VENERABLE_AGE;
	}


}
