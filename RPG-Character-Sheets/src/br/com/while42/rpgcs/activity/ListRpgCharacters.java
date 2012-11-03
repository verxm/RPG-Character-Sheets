package br.com.while42.rpgcs.activity;

import java.util.ArrayList;
import java.util.List;

import android.os.Bundle;
import android.widget.ListView;
import br.com.while42.rpgcs.R;
import br.com.while42.rpgcs.adapter.ListCharacterAdapter;
import br.com.while42.rpgcs.model.character.RpgCharacter;

import com.actionbarsherlock.app.SherlockActivity;

public class ListRpgCharacters extends SherlockActivity {

	private List<RpgCharacter> rpgCharacters = new ArrayList<RpgCharacter>();
	private ListCharacterAdapter adapter;
	private ListView listCharacters;
	
	@Override
	protected void onResume() {
		super.onResume();

		

		adapter.notifyDataSetChanged();
	}
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_list_characters);

		listCharacters = (ListView) findViewById(R.id_list_characters.listView_characters);    
		
		adapter = new ListCharacterAdapter(this, rpgCharacters);
		listCharacters.setAdapter(adapter);
	}
	
}
