package br.com.while42.rpgcs.persist;

import java.util.ArrayList;
import java.util.List;

import br.com.while42.rpgcs.model.character.RpgCharacter;
import br.com.while42.rpgcs.persist.dao.RpgCharacterDAO;

import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;


public class DataManager {

	public static final int DATABASE_VERSION = 11;

	private Context context;
	private SQLiteDatabase db;
	private boolean useDebugDb = false;

	private RpgCharacterDAO rpgCharacterDao;

	public DataManager(Context context, boolean useDebugDb) {
		this.context = context;
		this.useDebugDb = useDebugDb;
		openDb();
	}

	public SQLiteDatabase getDb() {
		return db;
	}

	public boolean closeDb() {
		if (db != null && db.isOpen()) {
			try {
				db.close();
				return true;
			} catch (SQLiteException e) {
				// Log.w("DataManager", e.getMessage());
			}
		}

		return false;
	}

	public boolean openDb() {
		if (db == null || !db.isOpen()) {
			db = new OpenHelper(context, useDebugDb).getWritableDatabase();

			// since we pass db into DAO, have to recreate DAO if db is
			// re-opened
			rpgCharacterDao = new RpgCharacterDAO(db);

			return true;
		}

		return false;
	}

	// Match operations

	public long saveRpgCharacter(RpgCharacter rpgCharacter) {
		long matchId = 0L;
		try {
			db.beginTransaction();
			matchId = rpgCharacterDao.save(rpgCharacter);

			db.setTransactionSuccessful();
		} catch (SQLException e) {
			// Log.e(context.getResources().getString(R.string.app_name),
			// "Error saving match (transaction rolled back)", e);
			matchId = 0L;
		} finally {
			db.endTransaction();
		}

		return matchId;
	}

	public RpgCharacter retrieveRpgCharacter(long rpgCharacterId) {
		RpgCharacter rpgCharacter = rpgCharacterDao.retrieve(rpgCharacterId);
		
		return rpgCharacter;
	}

	public List<RpgCharacter> retrieveAllRpgCharacters() {
		List<RpgCharacter> characters = new ArrayList<RpgCharacter>();

		return characters;
	}

	public boolean deleteRpgCharacter(RpgCharacter rpgCharacter) {
		boolean result = false;
		try {
			db.beginTransaction();
			if (rpgCharacter != null) {

				rpgCharacterDao.delete(rpgCharacter);
			}
			db.setTransactionSuccessful();
			result = true;
		} catch (SQLException e) {
			// Log.e(context.getResources().getString(R.string.app_name),
			// "Error deleting match (transaction rolled back)", e);
		} finally {
			db.endTransaction();
		}

		return result;
	}

}
