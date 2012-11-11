package br.com.while42.rpgcs.activity.fragment;

import java.util.ArrayList;
import java.util.List;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import br.com.while42.rpgcs.R;
import br.com.while42.rpgcs.activity.Element;
import br.com.while42.rpgcs.model.TypeCode;
import br.com.while42.rpgcs.model.character.Characteristics;
import br.com.while42.rpgcs.model.character.attributes.TypeGender;
import br.com.while42.rpgcs.model.character.attributes.TypeHairColor;
import br.com.while42.rpgcs.model.character.attributes.TypeRpgAlignment;
import br.com.while42.rpgcs.model.character.attributes.TypeRpgRace;
import br.com.while42.rpgcs.model.character.attributes.TypeRpgReligion;
import br.com.while42.rpgcs.model.character.attributes.TypeSkinColor;
import br.com.while42.rpgcs.model.character.attributes.TypeVision;

public class EditCharacteristics extends Fragment {

	private Characteristics characteristics;

	private EditText nameEditText;
	private Spinner raceSpinner;
	private Spinner alignmentSpinner;
	private Spinner genderSpinner;
	private Spinner religionSpinner;
	private Spinner visionSpinner;
	private EditText ageEditText;
	private EditText heightEditText;
	private EditText weightEditText;
	private Spinner hairSpinner;
	private Spinner skinSpinner;

	public EditCharacteristics() {
	}

	public EditCharacteristics(Characteristics characteristics) {
		this.characteristics = characteristics;
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

		View layout = inflater.inflate(R.layout.fragment_edit_characteristics, container, false);

		nameEditText = (EditText) layout.findViewById(R.id_frag_edit_characteristics.edittext_name);
		raceSpinner = (Spinner) layout.findViewById(R.id_frag_edit_characteristics.spinner_race);
		alignmentSpinner = (Spinner) layout.findViewById(R.id_frag_edit_characteristics.spinner_alignment);
		genderSpinner = (Spinner) layout.findViewById(R.id_frag_edit_characteristics.spinner_gender);
		religionSpinner = (Spinner) layout.findViewById(R.id_frag_edit_characteristics.spinner_religion);
		visionSpinner = (Spinner) layout.findViewById(R.id_frag_edit_characteristics.spinner_vision);
		ageEditText = (EditText) layout.findViewById(R.id_frag_edit_characteristics.edittext_age);
		heightEditText = (EditText) layout.findViewById(R.id_frag_edit_characteristics.edittext_height);
		weightEditText = (EditText) layout.findViewById(R.id_frag_edit_characteristics.edittext_weight);
		hairSpinner = (Spinner) layout.findViewById(R.id_frag_edit_characteristics.spinner_hair);
		skinSpinner = (Spinner) layout.findViewById(R.id_frag_edit_characteristics.spinner_skin);

		setOptionsSpinner(raceSpinner, TypeRpgRace.values());
		setOptionsSpinner(alignmentSpinner, TypeRpgAlignment.values());
		setOptionsSpinner(genderSpinner, TypeGender.values());
		setOptionsSpinner(religionSpinner, TypeRpgReligion.values());
		setOptionsSpinner(visionSpinner, TypeVision.values());
		setOptionsSpinner(hairSpinner, TypeHairColor.values());
		setOptionsSpinner(skinSpinner, TypeSkinColor.values());

		loadCharacteristics(characteristics);

		return layout;
	}

	private void loadCharacteristics(Characteristics characteristics) {

		if (characteristics == null)
			return;

		nameEditText.setText(characteristics.getName());

		setSelectionOptionsSpinner(raceSpinner, characteristics.getRace());
		setSelectionOptionsSpinner(alignmentSpinner, characteristics.getAlignment());
		setSelectionOptionsSpinner(genderSpinner, characteristics.getGender());
		setSelectionOptionsSpinner(religionSpinner, characteristics.getReligion());
		setSelectionOptionsSpinner(visionSpinner, characteristics.getVision());

		ageEditText.setText(characteristics.getAge().toString());
		heightEditText.setText(characteristics.getHeight().toString());
		weightEditText.setText(characteristics.getWeight().toString());

		setSelectionOptionsSpinner(hairSpinner, characteristics.getHair());
		setSelectionOptionsSpinner(skinSpinner, characteristics.getSkin());
	}

	public void saveCharacteristics() {
		Element item;

		// Name
		String name = nameEditText.getText().toString();
		characteristics.setName(name);

		// Race
		item = (Element) raceSpinner.getSelectedItem();
		TypeRpgRace race = (TypeRpgRace) item.getType();
		characteristics.setRace(race);

		// Alignment
		item = (Element) alignmentSpinner.getSelectedItem();
		TypeRpgAlignment alignment = (TypeRpgAlignment) item.getType();
		characteristics.setAlignment(alignment);

		// Gender
		item = (Element) genderSpinner.getSelectedItem();
		TypeGender gender = (TypeGender) item.getType();
		characteristics.setGender(gender);

		// Religion
		item = (Element) religionSpinner.getSelectedItem();
		TypeRpgReligion religion = (TypeRpgReligion) item.getType();
		characteristics.setReligion(religion);

		// Vision
		item = (Element) visionSpinner.getSelectedItem();
		TypeVision vision = (TypeVision) item.getType();
		characteristics.setVision(vision);

		// Age
		Integer age = Integer.getInteger(ageEditText.getText().toString(), 0);
		characteristics.setAge(age);

		// Height
		Integer height = Integer.getInteger(heightEditText.getText().toString(), 0);
		characteristics.setHeight(height);

		// Weight
		Integer weight = Integer.getInteger(weightEditText.getText().toString(), 0);
		characteristics.setWeight(weight);

		// Hair
		item = (Element) hairSpinner.getSelectedItem();
		TypeHairColor hair = (TypeHairColor) item.getType();
		characteristics.setHair(hair);

		// Skin
		item = (Element) skinSpinner.getSelectedItem();
		TypeSkinColor skin = (TypeSkinColor) item.getType();
		characteristics.setSkin(skin);
	}

	private void setSelectionOptionsSpinner(Spinner spinner, TypeCode type) {

		SpinnerAdapter adapter = spinner.getAdapter();
		for (int pos = 0; pos < adapter.getCount(); pos++) {
			Element item = (Element) adapter.getItem(pos);
			if (type.equals(item.getType())) {
				spinner.setSelection(pos);
				break;
			}
		}
	}

	private void setOptionsSpinner(Spinner spinner, TypeCode[] types) {

		List<Element> items = new ArrayList<Element>();
		for (TypeCode g : types) {
			items.add(new Element(g, getString(g.getCodeName())));
		}

		ArrayAdapter<Element> adapter = new ArrayAdapter<Element>(getActivity(), android.R.layout.simple_spinner_dropdown_item, items);

		spinner.setAdapter(adapter);
	}
}
