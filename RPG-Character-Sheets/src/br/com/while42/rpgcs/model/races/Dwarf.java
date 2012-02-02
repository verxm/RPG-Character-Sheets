package br.com.while42.rpgcs.model.races;

import br.com.while42.rpgcs.model.character.attributes.TypeRpgClass;

public class Dwarf extends Race {

	@Override
	public int getAdjustmentsOfConstitution() {
		return +2;
	}

	@Override
	public int getAdjustmentsOfCharisma() {
		return -2;
	}

	@Override
	public TypeRpgClass getFavoredClass() {
		return TypeRpgClass.FIGHTER;
	}

}
