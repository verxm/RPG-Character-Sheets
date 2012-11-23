package br.com.while42.rpgcs.persist;

import java.util.List;

import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import br.com.while42.rpgcs.model.character.RpgCharacter;
import br.com.while42.rpgcs.persist.dao.RpgCharacterDAO;

public class DataManager {

	public static final int DATABASE_VERSION = 25;

	private Context context;
	private SQLiteDatabase db;
	private boolean useDebugDb = false;

	private RpgCharacterDAO rpgCharacterDao;

	public DataManager(Context context) {
		this(context, false);
	}

	public DataManager(Context context, boolean useDebugDb) {
		this.context = context;
		this.useDebugDb = useDebugDb;
		openDb();
	}

	public SQLiteDatabase getDb() {
		return db;
	}

	public boolean isOpen() {
		return (db != null && db.isOpen());
	}

	public boolean closeDb() {
		if (isOpen()) {
			try {
				db.close();
				db = null;
				return true;
			} catch (SQLiteException e) {
				// Log.w("DataManager", e.getMessage());
			}
		}

		return false;
	}

	public boolean openDb() {
		if (!isOpen()) {
			db = new OpenHelper(context, useDebugDb).getWritableDatabase();

			// since we pass db into DAO, have to recreate DAO if db is
			// re-opened
			rpgCharacterDao = new RpgCharacterDAO(db);

			return true;
		}

		return false;
	}

	// Match operations

	public Long saveRpgCharacter(RpgCharacter rpgCharacter) {
		openDb();
		long matchId = 0L;

		if (rpgCharacter == null) {
			return matchId;
		}

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

	public RpgCharacter retrieveRpgCharacter(Long id) {
		openDb();
		return rpgCharacterDao.retrieve(id);
	}

	public List<RpgCharacter> retrieveAllRpgCharacters() {
		openDb();
		return rpgCharacterDao.retrieveAll();
	}

	public boolean deleteRpgCharacter(RpgCharacter rpgCharacter) {
		openDb();
		boolean result = false;

		if (rpgCharacter == null) {
			return result;
		}

		try {
			db.beginTransaction();
			rpgCharacterDao.delete(rpgCharacter);
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
