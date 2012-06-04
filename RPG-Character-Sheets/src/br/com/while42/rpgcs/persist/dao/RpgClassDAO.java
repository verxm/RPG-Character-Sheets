package br.com.while42.rpgcs.persist.dao;

import java.util.ArrayList;
import java.util.List;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;
import android.util.Log;
import br.com.while42.rpgcs.model.classes.AbstractRpgClass;
import br.com.while42.rpgcs.persist.TableColumnsUtils;
import br.com.while42.rpgcs.persist.table.RpgClassTable;
import br.com.while42.rpgcs.persist.table.RpgClassTable.RpgClassColumns;


public class RpgClassDAO  {

	private static final String INSERT = "INSERT INTO "
			+ RpgClassTable.NAME
			+ "("
			+ new TableColumnsUtils()
					.getAsCommaSeparatedStringWithoutFirstColumn(RpgClassColumns
							.get())
			+ ") VALUES "
			+ new TableColumnsUtils()
					.getQuestionMarksWithoutFirstColumn(RpgClassColumns.get());

	private SQLiteDatabase db;
	private SQLiteStatement insertStatement;

	public RpgClassDAO(SQLiteDatabase db) {
		this.db = db;
		insertStatement = db.compileStatement(INSERT);
	}
	
	public void save(Long idRpgCharacter, AbstractRpgClass rpgClass) {
		if (!idRpgCharacter.equals(0L)) {
			
			//db.insert(RpgCharacterTable.NAME, nullColumnHack, values)
			insertStatement.clearBindings();
			
			insertStatement.bindLong(1, idRpgCharacter);
			insertStatement.bindString(2, rpgClass.getClass().getName());
			insertStatement.bindLong(3, rpgClass.getClassLevel());
		
			Log.d(">>>>>>>>>>", rpgClass.getClass().getName());
		}
	}

	public void update(Long idRpgCharacter, AbstractRpgClass rpgClass) {
		//db.update(RpgCharacterTable.NAME, RpgCharacterTable.toContentValues(rpgCharacter), BaseColumns._ID
		//		+ " = ?", new String[] { String.valueOf(rpgCharacter.getId()) });
	}

	public void delete(Long idRpgCharacter, AbstractRpgClass rpgClass) {
		//if (rpgCharacter.isPersistent()) {
		//	db.delete(RpgCharacterTable.NAME, BaseColumns._ID + " = ?",
		//			new String[] { String.valueOf(rpgCharacter.getId()) });
		//	rpgCharacter.setId(0L);
		//}
	}


	public List<AbstractRpgClass> retrieveAll(Long idRpgCharacter) {
		List<AbstractRpgClass> myList = new ArrayList<AbstractRpgClass>();

		Cursor cursor = db.query(RpgClassTable.NAME, RpgClassColumns.get(), 
				RpgClassColumns.ID_RPG_CHARACTER + " = ?", // where
				new String[] { idRpgCharacter.toString() }, // values
				null, // group by
				null, // having
				RpgClassColumns.NAME, // order by
				null); // limit

		if (cursor.moveToFirst()) {
			do {
				AbstractRpgClass rpgClass = this.buildRpgClassFromCursor(cursor);
				myList.add(rpgClass);
			} while (cursor.moveToNext());
		}

		if (!cursor.isClosed()) {
			cursor.close();
		}

		return myList;
	}

	private AbstractRpgClass buildRpgClassFromCursor(Cursor cursor) {
		AbstractRpgClass rpgClass = null;

		if (cursor != null) {

			String className = cursor.getString(1);
			Integer level = cursor.getInt(2);
			
			try {
				@SuppressWarnings("unchecked")
				Class<AbstractRpgClass> c = (Class<AbstractRpgClass>) Class.forName(className);
				rpgClass = c.newInstance();
				rpgClass.setClassLevel(level);
				
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
				Log.e("Error: ClassNotFoundException", e.getStackTrace().toString());
			} catch (InstantiationException e) {
				e.printStackTrace();
				Log.e("Error: InstantiationException", e.getStackTrace().toString());
			} catch (IllegalAccessException e) {
				e.printStackTrace();
				Log.e("Error: IllegalAccessException", e.getStackTrace().toString());
			}
			
		}
		
		return rpgClass;
	}
	
}
