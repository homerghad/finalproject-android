package io.realm;


import android.annotation.TargetApi;
import android.os.Build;
import android.util.JsonReader;
import android.util.JsonToken;
import io.realm.ImportFlag;
import io.realm.ProxyUtils;
import io.realm.exceptions.RealmMigrationNeededException;
import io.realm.internal.ColumnInfo;
import io.realm.internal.NativeContext;
import io.realm.internal.OsList;
import io.realm.internal.OsMap;
import io.realm.internal.OsObject;
import io.realm.internal.OsObjectSchemaInfo;
import io.realm.internal.OsSchemaInfo;
import io.realm.internal.OsSet;
import io.realm.internal.Property;
import io.realm.internal.RealmObjectProxy;
import io.realm.internal.Row;
import io.realm.internal.Table;
import io.realm.internal.android.JsonUtils;
import io.realm.internal.core.NativeRealmAny;
import io.realm.internal.objectstore.OsObjectBuilder;
import io.realm.log.RealmLog;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@SuppressWarnings("all")
public class csci81_demo_finalproject_realm_MovieRealmProxy extends csci81.demo.finalproject.realm.Movie
    implements RealmObjectProxy, csci81_demo_finalproject_realm_MovieRealmProxyInterface {

    static final class MovieColumnInfo extends ColumnInfo {
        long movieIDColKey;
        long titleColKey;
        long directorColKey;
        long genreColKey;
        long releaseDateColKey;
        long rentalCostColKey;
        long rentalDurationColKey;

        MovieColumnInfo(OsSchemaInfo schemaInfo) {
            super(7);
            OsObjectSchemaInfo objectSchemaInfo = schemaInfo.getObjectSchemaInfo("Movie");
            this.movieIDColKey = addColumnDetails("movieID", "movieID", objectSchemaInfo);
            this.titleColKey = addColumnDetails("title", "title", objectSchemaInfo);
            this.directorColKey = addColumnDetails("director", "director", objectSchemaInfo);
            this.genreColKey = addColumnDetails("genre", "genre", objectSchemaInfo);
            this.releaseDateColKey = addColumnDetails("releaseDate", "releaseDate", objectSchemaInfo);
            this.rentalCostColKey = addColumnDetails("rentalCost", "rentalCost", objectSchemaInfo);
            this.rentalDurationColKey = addColumnDetails("rentalDuration", "rentalDuration", objectSchemaInfo);
        }

        MovieColumnInfo(ColumnInfo src, boolean mutable) {
            super(src, mutable);
            copy(src, this);
        }

        @Override
        protected final ColumnInfo copy(boolean mutable) {
            return new MovieColumnInfo(this, mutable);
        }

        @Override
        protected final void copy(ColumnInfo rawSrc, ColumnInfo rawDst) {
            final MovieColumnInfo src = (MovieColumnInfo) rawSrc;
            final MovieColumnInfo dst = (MovieColumnInfo) rawDst;
            dst.movieIDColKey = src.movieIDColKey;
            dst.titleColKey = src.titleColKey;
            dst.directorColKey = src.directorColKey;
            dst.genreColKey = src.genreColKey;
            dst.releaseDateColKey = src.releaseDateColKey;
            dst.rentalCostColKey = src.rentalCostColKey;
            dst.rentalDurationColKey = src.rentalDurationColKey;
        }
    }

    private static final String NO_ALIAS = "";
    private static final OsObjectSchemaInfo expectedObjectSchemaInfo = createExpectedObjectSchemaInfo();

    private MovieColumnInfo columnInfo;
    private ProxyState<csci81.demo.finalproject.realm.Movie> proxyState;

    csci81_demo_finalproject_realm_MovieRealmProxy() {
        proxyState.setConstructionFinished();
    }

    @Override
    public void realm$injectObjectContext() {
        if (this.proxyState != null) {
            return;
        }
        final BaseRealm.RealmObjectContext context = BaseRealm.objectContext.get();
        this.columnInfo = (MovieColumnInfo) context.getColumnInfo();
        this.proxyState = new ProxyState<csci81.demo.finalproject.realm.Movie>(this);
        proxyState.setRealm$realm(context.getRealm());
        proxyState.setRow$realm(context.getRow());
        proxyState.setAcceptDefaultValue$realm(context.getAcceptDefaultValue());
        proxyState.setExcludeFields$realm(context.getExcludeFields());
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$movieID() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.movieIDColKey);
    }

    @Override
    public void realmSet$movieID(String value) {
        if (proxyState.isUnderConstruction()) {
            // default value of the primary key is always ignored.
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        throw new io.realm.exceptions.RealmException("Primary key field 'movieID' cannot be changed after object was created.");
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$title() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.titleColKey);
    }

    @Override
    public void realmSet$title(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.titleColKey, row.getObjectKey(), true);
                return;
            }
            row.getTable().setString(columnInfo.titleColKey, row.getObjectKey(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.titleColKey);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.titleColKey, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$director() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.directorColKey);
    }

    @Override
    public void realmSet$director(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.directorColKey, row.getObjectKey(), true);
                return;
            }
            row.getTable().setString(columnInfo.directorColKey, row.getObjectKey(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.directorColKey);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.directorColKey, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$genre() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.genreColKey);
    }

    @Override
    public void realmSet$genre(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.genreColKey, row.getObjectKey(), true);
                return;
            }
            row.getTable().setString(columnInfo.genreColKey, row.getObjectKey(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.genreColKey);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.genreColKey, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$releaseDate() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.releaseDateColKey);
    }

    @Override
    public void realmSet$releaseDate(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.releaseDateColKey, row.getObjectKey(), true);
                return;
            }
            row.getTable().setString(columnInfo.releaseDateColKey, row.getObjectKey(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.releaseDateColKey);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.releaseDateColKey, value);
    }

    @Override
    @SuppressWarnings("cast")
    public double realmGet$rentalCost() {
        proxyState.getRealm$realm().checkIfValid();
        return (double) proxyState.getRow$realm().getDouble(columnInfo.rentalCostColKey);
    }

    @Override
    public void realmSet$rentalCost(double value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            row.getTable().setDouble(columnInfo.rentalCostColKey, row.getObjectKey(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        proxyState.getRow$realm().setDouble(columnInfo.rentalCostColKey, value);
    }

    @Override
    @SuppressWarnings("cast")
    public int realmGet$rentalDuration() {
        proxyState.getRealm$realm().checkIfValid();
        return (int) proxyState.getRow$realm().getLong(columnInfo.rentalDurationColKey);
    }

    @Override
    public void realmSet$rentalDuration(int value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            row.getTable().setLong(columnInfo.rentalDurationColKey, row.getObjectKey(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        proxyState.getRow$realm().setLong(columnInfo.rentalDurationColKey, value);
    }

    private static OsObjectSchemaInfo createExpectedObjectSchemaInfo() {
        OsObjectSchemaInfo.Builder builder = new OsObjectSchemaInfo.Builder(NO_ALIAS, "Movie", false, 7, 0);
        builder.addPersistedProperty(NO_ALIAS, "movieID", RealmFieldType.STRING, Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty(NO_ALIAS, "title", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty(NO_ALIAS, "director", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty(NO_ALIAS, "genre", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty(NO_ALIAS, "releaseDate", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty(NO_ALIAS, "rentalCost", RealmFieldType.DOUBLE, !Property.PRIMARY_KEY, !Property.INDEXED, Property.REQUIRED);
        builder.addPersistedProperty(NO_ALIAS, "rentalDuration", RealmFieldType.INTEGER, !Property.PRIMARY_KEY, !Property.INDEXED, Property.REQUIRED);
        return builder.build();
    }

    public static OsObjectSchemaInfo getExpectedObjectSchemaInfo() {
        return expectedObjectSchemaInfo;
    }

    public static MovieColumnInfo createColumnInfo(OsSchemaInfo schemaInfo) {
        return new MovieColumnInfo(schemaInfo);
    }

    public static String getSimpleClassName() {
        return "Movie";
    }

    public static final class ClassNameHelper {
        public static final String INTERNAL_CLASS_NAME = "Movie";
    }

    @SuppressWarnings("cast")
    public static csci81.demo.finalproject.realm.Movie createOrUpdateUsingJsonObject(Realm realm, JSONObject json, boolean update)
        throws JSONException {
        final List<String> excludeFields = Collections.<String> emptyList();
        csci81.demo.finalproject.realm.Movie obj = null;
        if (update) {
            Table table = realm.getTable(csci81.demo.finalproject.realm.Movie.class);
            MovieColumnInfo columnInfo = (MovieColumnInfo) realm.getSchema().getColumnInfo(csci81.demo.finalproject.realm.Movie.class);
            long pkColumnKey = columnInfo.movieIDColKey;
            long objKey = Table.NO_MATCH;
            if (json.isNull("movieID")) {
                objKey = table.findFirstNull(pkColumnKey);
            } else {
                objKey = table.findFirstString(pkColumnKey, json.getString("movieID"));
            }
            if (objKey != Table.NO_MATCH) {
                final BaseRealm.RealmObjectContext objectContext = BaseRealm.objectContext.get();
                try {
                    objectContext.set(realm, table.getUncheckedRow(objKey), realm.getSchema().getColumnInfo(csci81.demo.finalproject.realm.Movie.class), false, Collections.<String> emptyList());
                    obj = new io.realm.csci81_demo_finalproject_realm_MovieRealmProxy();
                } finally {
                    objectContext.clear();
                }
            }
        }
        if (obj == null) {
            if (json.has("movieID")) {
                if (json.isNull("movieID")) {
                    obj = (io.realm.csci81_demo_finalproject_realm_MovieRealmProxy) realm.createObjectInternal(csci81.demo.finalproject.realm.Movie.class, null, true, excludeFields);
                } else {
                    obj = (io.realm.csci81_demo_finalproject_realm_MovieRealmProxy) realm.createObjectInternal(csci81.demo.finalproject.realm.Movie.class, json.getString("movieID"), true, excludeFields);
                }
            } else {
                throw new IllegalArgumentException("JSON object doesn't have the primary key field 'movieID'.");
            }
        }

        final csci81_demo_finalproject_realm_MovieRealmProxyInterface objProxy = (csci81_demo_finalproject_realm_MovieRealmProxyInterface) obj;
        if (json.has("title")) {
            if (json.isNull("title")) {
                objProxy.realmSet$title(null);
            } else {
                objProxy.realmSet$title((String) json.getString("title"));
            }
        }
        if (json.has("director")) {
            if (json.isNull("director")) {
                objProxy.realmSet$director(null);
            } else {
                objProxy.realmSet$director((String) json.getString("director"));
            }
        }
        if (json.has("genre")) {
            if (json.isNull("genre")) {
                objProxy.realmSet$genre(null);
            } else {
                objProxy.realmSet$genre((String) json.getString("genre"));
            }
        }
        if (json.has("releaseDate")) {
            if (json.isNull("releaseDate")) {
                objProxy.realmSet$releaseDate(null);
            } else {
                objProxy.realmSet$releaseDate((String) json.getString("releaseDate"));
            }
        }
        if (json.has("rentalCost")) {
            if (json.isNull("rentalCost")) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'rentalCost' to null.");
            } else {
                objProxy.realmSet$rentalCost((double) json.getDouble("rentalCost"));
            }
        }
        if (json.has("rentalDuration")) {
            if (json.isNull("rentalDuration")) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'rentalDuration' to null.");
            } else {
                objProxy.realmSet$rentalDuration((int) json.getInt("rentalDuration"));
            }
        }
        return obj;
    }

    @SuppressWarnings("cast")
    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    public static csci81.demo.finalproject.realm.Movie createUsingJsonStream(Realm realm, JsonReader reader)
        throws IOException {
        boolean jsonHasPrimaryKey = false;
        final csci81.demo.finalproject.realm.Movie obj = new csci81.demo.finalproject.realm.Movie();
        final csci81_demo_finalproject_realm_MovieRealmProxyInterface objProxy = (csci81_demo_finalproject_realm_MovieRealmProxyInterface) obj;
        reader.beginObject();
        while (reader.hasNext()) {
            String name = reader.nextName();
            if (false) {
            } else if (name.equals("movieID")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$movieID((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$movieID(null);
                }
                jsonHasPrimaryKey = true;
            } else if (name.equals("title")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$title((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$title(null);
                }
            } else if (name.equals("director")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$director((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$director(null);
                }
            } else if (name.equals("genre")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$genre((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$genre(null);
                }
            } else if (name.equals("releaseDate")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$releaseDate((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$releaseDate(null);
                }
            } else if (name.equals("rentalCost")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$rentalCost((double) reader.nextDouble());
                } else {
                    reader.skipValue();
                    throw new IllegalArgumentException("Trying to set non-nullable field 'rentalCost' to null.");
                }
            } else if (name.equals("rentalDuration")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$rentalDuration((int) reader.nextInt());
                } else {
                    reader.skipValue();
                    throw new IllegalArgumentException("Trying to set non-nullable field 'rentalDuration' to null.");
                }
            } else {
                reader.skipValue();
            }
        }
        reader.endObject();
        if (!jsonHasPrimaryKey) {
            throw new IllegalArgumentException("JSON object doesn't have the primary key field 'movieID'.");
        }
        return realm.copyToRealmOrUpdate(obj);
    }

    static csci81_demo_finalproject_realm_MovieRealmProxy newProxyInstance(BaseRealm realm, Row row) {
        // Ignore default values to avoid creating unexpected objects from RealmModel/RealmList fields
        final BaseRealm.RealmObjectContext objectContext = BaseRealm.objectContext.get();
        objectContext.set(realm, row, realm.getSchema().getColumnInfo(csci81.demo.finalproject.realm.Movie.class), false, Collections.<String>emptyList());
        io.realm.csci81_demo_finalproject_realm_MovieRealmProxy obj = new io.realm.csci81_demo_finalproject_realm_MovieRealmProxy();
        objectContext.clear();
        return obj;
    }

    public static csci81.demo.finalproject.realm.Movie copyOrUpdate(Realm realm, MovieColumnInfo columnInfo, csci81.demo.finalproject.realm.Movie object, boolean update, Map<RealmModel,RealmObjectProxy> cache, Set<ImportFlag> flags) {
        if (object instanceof RealmObjectProxy && !RealmObject.isFrozen(object) && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null) {
            final BaseRealm otherRealm = ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm();
            if (otherRealm.threadId != realm.threadId) {
                throw new IllegalArgumentException("Objects which belong to Realm instances in other threads cannot be copied into this Realm instance.");
            }
            if (otherRealm.getPath().equals(realm.getPath())) {
                return object;
            }
        }
        final BaseRealm.RealmObjectContext objectContext = BaseRealm.objectContext.get();
        RealmObjectProxy cachedRealmObject = cache.get(object);
        if (cachedRealmObject != null) {
            return (csci81.demo.finalproject.realm.Movie) cachedRealmObject;
        }

        csci81.demo.finalproject.realm.Movie realmObject = null;
        boolean canUpdate = update;
        if (canUpdate) {
            Table table = realm.getTable(csci81.demo.finalproject.realm.Movie.class);
            long pkColumnKey = columnInfo.movieIDColKey;
            String value = ((csci81_demo_finalproject_realm_MovieRealmProxyInterface) object).realmGet$movieID();
            long objKey = Table.NO_MATCH;
            if (value == null) {
                objKey = table.findFirstNull(pkColumnKey);
            } else {
                objKey = table.findFirstString(pkColumnKey, value);
            }
            if (objKey == Table.NO_MATCH) {
                canUpdate = false;
            } else {
                try {
                    objectContext.set(realm, table.getUncheckedRow(objKey), columnInfo, false, Collections.<String> emptyList());
                    realmObject = new io.realm.csci81_demo_finalproject_realm_MovieRealmProxy();
                    cache.put(object, (RealmObjectProxy) realmObject);
                } finally {
                    objectContext.clear();
                }
            }
        }

        return (canUpdate) ? update(realm, columnInfo, realmObject, object, cache, flags) : copy(realm, columnInfo, object, update, cache, flags);
    }

    public static csci81.demo.finalproject.realm.Movie copy(Realm realm, MovieColumnInfo columnInfo, csci81.demo.finalproject.realm.Movie newObject, boolean update, Map<RealmModel,RealmObjectProxy> cache, Set<ImportFlag> flags) {
        RealmObjectProxy cachedRealmObject = cache.get(newObject);
        if (cachedRealmObject != null) {
            return (csci81.demo.finalproject.realm.Movie) cachedRealmObject;
        }

        csci81_demo_finalproject_realm_MovieRealmProxyInterface unmanagedSource = (csci81_demo_finalproject_realm_MovieRealmProxyInterface) newObject;

        Table table = realm.getTable(csci81.demo.finalproject.realm.Movie.class);
        OsObjectBuilder builder = new OsObjectBuilder(table, flags);

        // Add all non-"object reference" fields
        builder.addString(columnInfo.movieIDColKey, unmanagedSource.realmGet$movieID());
        builder.addString(columnInfo.titleColKey, unmanagedSource.realmGet$title());
        builder.addString(columnInfo.directorColKey, unmanagedSource.realmGet$director());
        builder.addString(columnInfo.genreColKey, unmanagedSource.realmGet$genre());
        builder.addString(columnInfo.releaseDateColKey, unmanagedSource.realmGet$releaseDate());
        builder.addDouble(columnInfo.rentalCostColKey, unmanagedSource.realmGet$rentalCost());
        builder.addInteger(columnInfo.rentalDurationColKey, unmanagedSource.realmGet$rentalDuration());

        // Create the underlying object and cache it before setting any object/objectlist references
        // This will allow us to break any circular dependencies by using the object cache.
        Row row = builder.createNewObject();
        io.realm.csci81_demo_finalproject_realm_MovieRealmProxy managedCopy = newProxyInstance(realm, row);
        cache.put(newObject, managedCopy);

        return managedCopy;
    }

    public static long insert(Realm realm, csci81.demo.finalproject.realm.Movie object, Map<RealmModel,Long> cache) {
        if (object instanceof RealmObjectProxy && !RealmObject.isFrozen(object) && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getObjectKey();
        }
        Table table = realm.getTable(csci81.demo.finalproject.realm.Movie.class);
        long tableNativePtr = table.getNativePtr();
        MovieColumnInfo columnInfo = (MovieColumnInfo) realm.getSchema().getColumnInfo(csci81.demo.finalproject.realm.Movie.class);
        long pkColumnKey = columnInfo.movieIDColKey;
        String primaryKeyValue = ((csci81_demo_finalproject_realm_MovieRealmProxyInterface) object).realmGet$movieID();
        long objKey = Table.NO_MATCH;
        if (primaryKeyValue == null) {
            objKey = Table.nativeFindFirstNull(tableNativePtr, pkColumnKey);
        } else {
            objKey = Table.nativeFindFirstString(tableNativePtr, pkColumnKey, primaryKeyValue);
        }
        if (objKey == Table.NO_MATCH) {
            objKey = OsObject.createRowWithPrimaryKey(table, pkColumnKey, primaryKeyValue);
        } else {
            Table.throwDuplicatePrimaryKeyException(primaryKeyValue);
        }
        cache.put(object, objKey);
        String realmGet$title = ((csci81_demo_finalproject_realm_MovieRealmProxyInterface) object).realmGet$title();
        if (realmGet$title != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.titleColKey, objKey, realmGet$title, false);
        }
        String realmGet$director = ((csci81_demo_finalproject_realm_MovieRealmProxyInterface) object).realmGet$director();
        if (realmGet$director != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.directorColKey, objKey, realmGet$director, false);
        }
        String realmGet$genre = ((csci81_demo_finalproject_realm_MovieRealmProxyInterface) object).realmGet$genre();
        if (realmGet$genre != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.genreColKey, objKey, realmGet$genre, false);
        }
        String realmGet$releaseDate = ((csci81_demo_finalproject_realm_MovieRealmProxyInterface) object).realmGet$releaseDate();
        if (realmGet$releaseDate != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.releaseDateColKey, objKey, realmGet$releaseDate, false);
        }
        Table.nativeSetDouble(tableNativePtr, columnInfo.rentalCostColKey, objKey, ((csci81_demo_finalproject_realm_MovieRealmProxyInterface) object).realmGet$rentalCost(), false);
        Table.nativeSetLong(tableNativePtr, columnInfo.rentalDurationColKey, objKey, ((csci81_demo_finalproject_realm_MovieRealmProxyInterface) object).realmGet$rentalDuration(), false);
        return objKey;
    }

    public static void insert(Realm realm, Iterator<? extends RealmModel> objects, Map<RealmModel,Long> cache) {
        Table table = realm.getTable(csci81.demo.finalproject.realm.Movie.class);
        long tableNativePtr = table.getNativePtr();
        MovieColumnInfo columnInfo = (MovieColumnInfo) realm.getSchema().getColumnInfo(csci81.demo.finalproject.realm.Movie.class);
        long pkColumnKey = columnInfo.movieIDColKey;
        csci81.demo.finalproject.realm.Movie object = null;
        while (objects.hasNext()) {
            object = (csci81.demo.finalproject.realm.Movie) objects.next();
            if (cache.containsKey(object)) {
                continue;
            }
            if (object instanceof RealmObjectProxy && !RealmObject.isFrozen(object) && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                cache.put(object, ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getObjectKey());
                continue;
            }
            String primaryKeyValue = ((csci81_demo_finalproject_realm_MovieRealmProxyInterface) object).realmGet$movieID();
            long objKey = Table.NO_MATCH;
            if (primaryKeyValue == null) {
                objKey = Table.nativeFindFirstNull(tableNativePtr, pkColumnKey);
            } else {
                objKey = Table.nativeFindFirstString(tableNativePtr, pkColumnKey, primaryKeyValue);
            }
            if (objKey == Table.NO_MATCH) {
                objKey = OsObject.createRowWithPrimaryKey(table, pkColumnKey, primaryKeyValue);
            } else {
                Table.throwDuplicatePrimaryKeyException(primaryKeyValue);
            }
            cache.put(object, objKey);
            String realmGet$title = ((csci81_demo_finalproject_realm_MovieRealmProxyInterface) object).realmGet$title();
            if (realmGet$title != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.titleColKey, objKey, realmGet$title, false);
            }
            String realmGet$director = ((csci81_demo_finalproject_realm_MovieRealmProxyInterface) object).realmGet$director();
            if (realmGet$director != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.directorColKey, objKey, realmGet$director, false);
            }
            String realmGet$genre = ((csci81_demo_finalproject_realm_MovieRealmProxyInterface) object).realmGet$genre();
            if (realmGet$genre != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.genreColKey, objKey, realmGet$genre, false);
            }
            String realmGet$releaseDate = ((csci81_demo_finalproject_realm_MovieRealmProxyInterface) object).realmGet$releaseDate();
            if (realmGet$releaseDate != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.releaseDateColKey, objKey, realmGet$releaseDate, false);
            }
            Table.nativeSetDouble(tableNativePtr, columnInfo.rentalCostColKey, objKey, ((csci81_demo_finalproject_realm_MovieRealmProxyInterface) object).realmGet$rentalCost(), false);
            Table.nativeSetLong(tableNativePtr, columnInfo.rentalDurationColKey, objKey, ((csci81_demo_finalproject_realm_MovieRealmProxyInterface) object).realmGet$rentalDuration(), false);
        }
    }

    public static long insertOrUpdate(Realm realm, csci81.demo.finalproject.realm.Movie object, Map<RealmModel,Long> cache) {
        if (object instanceof RealmObjectProxy && !RealmObject.isFrozen(object) && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getObjectKey();
        }
        Table table = realm.getTable(csci81.demo.finalproject.realm.Movie.class);
        long tableNativePtr = table.getNativePtr();
        MovieColumnInfo columnInfo = (MovieColumnInfo) realm.getSchema().getColumnInfo(csci81.demo.finalproject.realm.Movie.class);
        long pkColumnKey = columnInfo.movieIDColKey;
        String primaryKeyValue = ((csci81_demo_finalproject_realm_MovieRealmProxyInterface) object).realmGet$movieID();
        long objKey = Table.NO_MATCH;
        if (primaryKeyValue == null) {
            objKey = Table.nativeFindFirstNull(tableNativePtr, pkColumnKey);
        } else {
            objKey = Table.nativeFindFirstString(tableNativePtr, pkColumnKey, primaryKeyValue);
        }
        if (objKey == Table.NO_MATCH) {
            objKey = OsObject.createRowWithPrimaryKey(table, pkColumnKey, primaryKeyValue);
        }
        cache.put(object, objKey);
        String realmGet$title = ((csci81_demo_finalproject_realm_MovieRealmProxyInterface) object).realmGet$title();
        if (realmGet$title != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.titleColKey, objKey, realmGet$title, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.titleColKey, objKey, false);
        }
        String realmGet$director = ((csci81_demo_finalproject_realm_MovieRealmProxyInterface) object).realmGet$director();
        if (realmGet$director != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.directorColKey, objKey, realmGet$director, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.directorColKey, objKey, false);
        }
        String realmGet$genre = ((csci81_demo_finalproject_realm_MovieRealmProxyInterface) object).realmGet$genre();
        if (realmGet$genre != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.genreColKey, objKey, realmGet$genre, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.genreColKey, objKey, false);
        }
        String realmGet$releaseDate = ((csci81_demo_finalproject_realm_MovieRealmProxyInterface) object).realmGet$releaseDate();
        if (realmGet$releaseDate != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.releaseDateColKey, objKey, realmGet$releaseDate, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.releaseDateColKey, objKey, false);
        }
        Table.nativeSetDouble(tableNativePtr, columnInfo.rentalCostColKey, objKey, ((csci81_demo_finalproject_realm_MovieRealmProxyInterface) object).realmGet$rentalCost(), false);
        Table.nativeSetLong(tableNativePtr, columnInfo.rentalDurationColKey, objKey, ((csci81_demo_finalproject_realm_MovieRealmProxyInterface) object).realmGet$rentalDuration(), false);
        return objKey;
    }

    public static void insertOrUpdate(Realm realm, Iterator<? extends RealmModel> objects, Map<RealmModel,Long> cache) {
        Table table = realm.getTable(csci81.demo.finalproject.realm.Movie.class);
        long tableNativePtr = table.getNativePtr();
        MovieColumnInfo columnInfo = (MovieColumnInfo) realm.getSchema().getColumnInfo(csci81.demo.finalproject.realm.Movie.class);
        long pkColumnKey = columnInfo.movieIDColKey;
        csci81.demo.finalproject.realm.Movie object = null;
        while (objects.hasNext()) {
            object = (csci81.demo.finalproject.realm.Movie) objects.next();
            if (cache.containsKey(object)) {
                continue;
            }
            if (object instanceof RealmObjectProxy && !RealmObject.isFrozen(object) && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                cache.put(object, ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getObjectKey());
                continue;
            }
            String primaryKeyValue = ((csci81_demo_finalproject_realm_MovieRealmProxyInterface) object).realmGet$movieID();
            long objKey = Table.NO_MATCH;
            if (primaryKeyValue == null) {
                objKey = Table.nativeFindFirstNull(tableNativePtr, pkColumnKey);
            } else {
                objKey = Table.nativeFindFirstString(tableNativePtr, pkColumnKey, primaryKeyValue);
            }
            if (objKey == Table.NO_MATCH) {
                objKey = OsObject.createRowWithPrimaryKey(table, pkColumnKey, primaryKeyValue);
            }
            cache.put(object, objKey);
            String realmGet$title = ((csci81_demo_finalproject_realm_MovieRealmProxyInterface) object).realmGet$title();
            if (realmGet$title != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.titleColKey, objKey, realmGet$title, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.titleColKey, objKey, false);
            }
            String realmGet$director = ((csci81_demo_finalproject_realm_MovieRealmProxyInterface) object).realmGet$director();
            if (realmGet$director != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.directorColKey, objKey, realmGet$director, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.directorColKey, objKey, false);
            }
            String realmGet$genre = ((csci81_demo_finalproject_realm_MovieRealmProxyInterface) object).realmGet$genre();
            if (realmGet$genre != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.genreColKey, objKey, realmGet$genre, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.genreColKey, objKey, false);
            }
            String realmGet$releaseDate = ((csci81_demo_finalproject_realm_MovieRealmProxyInterface) object).realmGet$releaseDate();
            if (realmGet$releaseDate != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.releaseDateColKey, objKey, realmGet$releaseDate, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.releaseDateColKey, objKey, false);
            }
            Table.nativeSetDouble(tableNativePtr, columnInfo.rentalCostColKey, objKey, ((csci81_demo_finalproject_realm_MovieRealmProxyInterface) object).realmGet$rentalCost(), false);
            Table.nativeSetLong(tableNativePtr, columnInfo.rentalDurationColKey, objKey, ((csci81_demo_finalproject_realm_MovieRealmProxyInterface) object).realmGet$rentalDuration(), false);
        }
    }

    public static csci81.demo.finalproject.realm.Movie createDetachedCopy(csci81.demo.finalproject.realm.Movie realmObject, int currentDepth, int maxDepth, Map<RealmModel, CacheData<RealmModel>> cache) {
        if (currentDepth > maxDepth || realmObject == null) {
            return null;
        }
        CacheData<RealmModel> cachedObject = cache.get(realmObject);
        csci81.demo.finalproject.realm.Movie unmanagedObject;
        if (cachedObject == null) {
            unmanagedObject = new csci81.demo.finalproject.realm.Movie();
            cache.put(realmObject, new RealmObjectProxy.CacheData<RealmModel>(currentDepth, unmanagedObject));
        } else {
            // Reuse cached object or recreate it because it was encountered at a lower depth.
            if (currentDepth >= cachedObject.minDepth) {
                return (csci81.demo.finalproject.realm.Movie) cachedObject.object;
            }
            unmanagedObject = (csci81.demo.finalproject.realm.Movie) cachedObject.object;
            cachedObject.minDepth = currentDepth;
        }
        csci81_demo_finalproject_realm_MovieRealmProxyInterface unmanagedCopy = (csci81_demo_finalproject_realm_MovieRealmProxyInterface) unmanagedObject;
        csci81_demo_finalproject_realm_MovieRealmProxyInterface realmSource = (csci81_demo_finalproject_realm_MovieRealmProxyInterface) realmObject;
        Realm objectRealm = (Realm) ((RealmObjectProxy) realmObject).realmGet$proxyState().getRealm$realm();
        unmanagedCopy.realmSet$movieID(realmSource.realmGet$movieID());
        unmanagedCopy.realmSet$title(realmSource.realmGet$title());
        unmanagedCopy.realmSet$director(realmSource.realmGet$director());
        unmanagedCopy.realmSet$genre(realmSource.realmGet$genre());
        unmanagedCopy.realmSet$releaseDate(realmSource.realmGet$releaseDate());
        unmanagedCopy.realmSet$rentalCost(realmSource.realmGet$rentalCost());
        unmanagedCopy.realmSet$rentalDuration(realmSource.realmGet$rentalDuration());

        return unmanagedObject;
    }

    static csci81.demo.finalproject.realm.Movie update(Realm realm, MovieColumnInfo columnInfo, csci81.demo.finalproject.realm.Movie realmObject, csci81.demo.finalproject.realm.Movie newObject, Map<RealmModel, RealmObjectProxy> cache, Set<ImportFlag> flags) {
        csci81_demo_finalproject_realm_MovieRealmProxyInterface realmObjectTarget = (csci81_demo_finalproject_realm_MovieRealmProxyInterface) realmObject;
        csci81_demo_finalproject_realm_MovieRealmProxyInterface realmObjectSource = (csci81_demo_finalproject_realm_MovieRealmProxyInterface) newObject;
        Table table = realm.getTable(csci81.demo.finalproject.realm.Movie.class);
        OsObjectBuilder builder = new OsObjectBuilder(table, flags);
        builder.addString(columnInfo.movieIDColKey, realmObjectSource.realmGet$movieID());
        builder.addString(columnInfo.titleColKey, realmObjectSource.realmGet$title());
        builder.addString(columnInfo.directorColKey, realmObjectSource.realmGet$director());
        builder.addString(columnInfo.genreColKey, realmObjectSource.realmGet$genre());
        builder.addString(columnInfo.releaseDateColKey, realmObjectSource.realmGet$releaseDate());
        builder.addDouble(columnInfo.rentalCostColKey, realmObjectSource.realmGet$rentalCost());
        builder.addInteger(columnInfo.rentalDurationColKey, realmObjectSource.realmGet$rentalDuration());

        builder.updateExistingTopLevelObject();
        return realmObject;
    }

    @Override
    public ProxyState<?> realmGet$proxyState() {
        return proxyState;
    }

    @Override
    public int hashCode() {
        String realmName = proxyState.getRealm$realm().getPath();
        String tableName = proxyState.getRow$realm().getTable().getName();
        long objKey = proxyState.getRow$realm().getObjectKey();

        int result = 17;
        result = 31 * result + ((realmName != null) ? realmName.hashCode() : 0);
        result = 31 * result + ((tableName != null) ? tableName.hashCode() : 0);
        result = 31 * result + (int) (objKey ^ (objKey >>> 32));
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        csci81_demo_finalproject_realm_MovieRealmProxy aMovie = (csci81_demo_finalproject_realm_MovieRealmProxy)o;

        BaseRealm realm = proxyState.getRealm$realm();
        BaseRealm otherRealm = aMovie.proxyState.getRealm$realm();
        String path = realm.getPath();
        String otherPath = otherRealm.getPath();
        if (path != null ? !path.equals(otherPath) : otherPath != null) return false;
        if (realm.isFrozen() != otherRealm.isFrozen()) return false;
        if (!realm.sharedRealm.getVersionID().equals(otherRealm.sharedRealm.getVersionID())) {
            return false;
        }

        String tableName = proxyState.getRow$realm().getTable().getName();
        String otherTableName = aMovie.proxyState.getRow$realm().getTable().getName();
        if (tableName != null ? !tableName.equals(otherTableName) : otherTableName != null) return false;

        if (proxyState.getRow$realm().getObjectKey() != aMovie.proxyState.getRow$realm().getObjectKey()) return false;

        return true;
    }
}
