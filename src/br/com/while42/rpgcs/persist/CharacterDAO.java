package br.com.while42.rpgcs.persist;

import java.util.ArrayList;
import java.util.List;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import br.com.while42.rpgcs.model.Character;

public class CharacterDAO extends SQLiteOpenHelper {
	
	private static final int VERSION = 1;
	private static final String TABLE = "character";
	private static final String[] COLS = {"id", "name"};	

	public CharacterDAO(Context context) {
		super(context, TABLE, null, VERSION);
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		StringBuilder sb = new StringBuilder();		
		sb.append("CREATE TABLE ").append(TABLE).append(" (");
		sb.append("id INTEGER PRIMARY KEY, ");
		sb.append("name TEXT UNIQUE NOT NULL ");		
		sb.append(")");
		
		db.execSQL(sb.toString());

	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		
		StringBuilder sb = new StringBuilder();
		sb.append("DROP TABLE IF EXISTS ").append(TABLE);
		db.execSQL(sb.toString());
		
		onCreate(db);

	}
	
public void save(Character character) {			
		
		ContentValues values = toValues(character);
				
		if (!character.isPersistent()) {
			
			long insert = getWritableDatabase().insert(TABLE, null, values);
			character.setId(insert);
			
		} else {
			String[] whereArgs = new String[] { Long.toString(character.getId()) };
			getWritableDatabase().update(TABLE, values, "id=?", whereArgs );
		}
	}
		
	public void delete(Character student) {		
		
		String[] whereArgs = new String[] { Long.toString(student.getId()) };
		getWritableDatabase().delete(TABLE, "id=?", whereArgs);		
	}
	
	
	public List<Character> getList() {			
		
		List<Character> characters = new ArrayList<Character>();		
		Cursor cursor = getWritableDatabase().query(TABLE, 
				COLS,    // Colunas 
				null,    // where
				null,    // values
				null,    // group by
				null,    // having
				"name"); // order by
		
		while (cursor.moveToNext()) {
			
			Character character = new Character();
			
			character.setId(cursor.getInt(0));
			character.setName(cursor.getString(1));
			
			characters.add(character);
		}
		
		cursor.close();
		
		return characters;
	}
	
public ContentValues toValues(Character character) {
		
		ContentValues values = new ContentValues();
		
		if (character.isPersistent())
		{
			values.put("id", character.getId());
		}
		
		values.put("name", character.getName());
		
		return values;
	}

}
