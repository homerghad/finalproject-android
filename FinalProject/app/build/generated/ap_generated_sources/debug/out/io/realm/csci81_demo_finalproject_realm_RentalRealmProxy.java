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
public class csci81_demo_finalproject_realm_RentalRealmProxy extends csci81.demo.finalproject.realm.Rental
    implements RealmObjectProxy, csci81_demo_finalproject_realm_RentalRealmProxyInterface {

    static final class RentalColumnInfo extends ColumnInfo {
        long rentalIDColKey;
        long transactionIDColKey;
        long userIDColKey;
        long movieIDColKey;
        long statusColKey;
        long rentalDateColKey;
        long returnDateColKey;
        long quantityColKey;

        RentalColumnInfo(OsSchemaInfo schemaInfo) {
            super(8);
            OsObjectSchemaInfo objectSchemaInfo = schemaInfo.getObjectSchemaInfo("Rental");
            this.rentalIDColKey = addColumnDetails("rentalID", "rentalID", objectSchemaInfo);
            this.transactionIDColKey = addColumnDetails("transactionID", "transactionID", objectSchemaInfo);
            this.userIDColKey = addColumnDetails("userID", "userID", objectSchemaInfo);
            this.movieIDColKey = addColumnDetails("movieID", "movieID", objectSchemaInfo);
            this.statusColKey = addColumnDetails("status", "status", objectSchemaInfo);
            this.rentalDateColKey = addColumnDetails("rentalDate", "rentalDate", objectSchemaInfo);
            this.returnDateColKey = addColumnDetails("returnDate", "returnDate", objectSchemaInfo);
            this.quantityColKey = addColumnDetails("quantity", "quantity", objectSchemaInfo);
        }

        RentalColumnInfo(ColumnInfo src, boolean mutable) {
            super(src, mutable);
            copy(src, this);
        }

        @Override
        protected final ColumnInfo copy(boolean mutable) {
            return new RentalColumnInfo(this, mutable);
        }

        @Override
        protected final void copy(ColumnInfo rawSrc, ColumnInfo rawDst) {
            final RentalColumnInfo src = (RentalColumnInfo) rawSrc;
            final RentalColumnInfo dst = (RentalColumnInfo) rawDst;
            dst.rentalIDColKey = src.rentalIDColKey;
            dst.transactionIDColKey = src.transactionIDColKey;
            dst.userIDColKey = src.userIDColKey;
            dst.movieIDColKey = src.movieIDColKey;
            dst.statusColKey = src.statusColKey;
            dst.rentalDateColKey = src.rentalDateColKey;
            dst.returnDateColKey = src.returnDateColKey;
            dst.quantityColKey = src.quantityColKey;
        }
    }

    private static final String NO_ALIAS = "";
    private static final OsObjectSchemaInfo expectedObjectSchemaInfo = createExpectedObjectSchemaInfo();

    private RentalColumnInfo columnInfo;
    private ProxyState<csci81.demo.finalproject.realm.Rental> proxyState;

    csci81_demo_finalproject_realm_RentalRealmProxy() {
        proxyState.setConstructionFinished();
    }

    @Override
    public void realm$injectObjectContext() {
        if (this.proxyState != null) {
            return;
        }
        final BaseRealm.RealmObjectContext context = BaseRealm.objectContext.get();
        this.columnInfo = (RentalColumnInfo) context.getColumnInfo();
        this.proxyState = new ProxyState<csci81.demo.finalproject.realm.Rental>(this);
        proxyState.setRealm$realm(context.getRealm());
        proxyState.setRow$realm(context.getRow());
        proxyState.setAcceptDefaultValue$realm(context.getAcceptDefaultValue());
        proxyState.setExcludeFields$realm(context.getExcludeFields());
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$rentalID() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.rentalIDColKey);
    }

    @Override
    public void realmSet$rentalID(String value) {
        if (proxyState.isUnderConstruction()) {
            // default value of the primary key is always ignored.
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        throw new io.realm.exceptions.RealmException("Primary key field 'rentalID' cannot be changed after object was created.");
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$transactionID() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.transactionIDColKey);
    }

    @Override
    public void realmSet$transactionID(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.transactionIDColKey, row.getObjectKey(), true);
                return;
            }
            row.getTable().setString(columnInfo.transactionIDColKey, row.getObjectKey(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.transactionIDColKey);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.transactionIDColKey, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$userID() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.userIDColKey);
    }

    @Override
    public void realmSet$userID(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.userIDColKey, row.getObjectKey(), true);
                return;
            }
            row.getTable().setString(columnInfo.userIDColKey, row.getObjectKey(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.userIDColKey);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.userIDColKey, value);
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
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.movieIDColKey, row.getObjectKey(), true);
                return;
            }
            row.getTable().setString(columnInfo.movieIDColKey, row.getObjectKey(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.movieIDColKey);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.movieIDColKey, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$status() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.statusColKey);
    }

    @Override
    public void realmSet$status(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.statusColKey, row.getObjectKey(), true);
                return;
            }
            row.getTable().setString(columnInfo.statusColKey, row.getObjectKey(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.statusColKey);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.statusColKey, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$rentalDate() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.rentalDateColKey);
    }

    @Override
    public void realmSet$rentalDate(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.rentalDateColKey, row.getObjectKey(), true);
                return;
            }
            row.getTable().setString(columnInfo.rentalDateColKey, row.getObjectKey(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.rentalDateColKey);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.rentalDateColKey, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$returnDate() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.returnDateColKey);
    }

    @Override
    public void realmSet$returnDate(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.returnDateColKey, row.getObjectKey(), true);
                return;
            }
            row.getTable().setString(columnInfo.returnDateColKey, row.getObjectKey(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.returnDateColKey);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.returnDateColKey, value);
    }

    @Override
    @SuppressWarnings("cast")
    public int realmGet$quantity() {
        proxyState.getRealm$realm().checkIfValid();
        return (int) proxyState.getRow$realm().getLong(columnInfo.quantityColKey);
    }

    @Override
    public void realmSet$quantity(int value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            row.getTable().setLong(columnInfo.quantityColKey, row.getObjectKey(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        proxyState.getRow$realm().setLong(columnInfo.quantityColKey, value);
    }

    private static OsObjectSchemaInfo createExpectedObjectSchemaInfo() {
        OsObjectSchemaInfo.Builder builder = new OsObjectSchemaInfo.Builder(NO_ALIAS, "Rental", false, 8, 0);
        builder.addPersistedProperty(NO_ALIAS, "rentalID", RealmFieldType.STRING, Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty(NO_ALIAS, "transactionID", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty(NO_ALIAS, "userID", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty(NO_ALIAS, "movieID", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty(NO_ALIAS, "status", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty(NO_ALIAS, "rentalDate", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty(NO_ALIAS, "returnDate", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty(NO_ALIAS, "quantity", RealmFieldType.INTEGER, !Property.PRIMARY_KEY, !Property.INDEXED, Property.REQUIRED);
        return builder.build();
    }

    public static OsObjectSchemaInfo getExpectedObjectSchemaInfo() {
        return expectedObjectSchemaInfo;
    }

    public static RentalColumnInfo createColumnInfo(OsSchemaInfo schemaInfo) {
        return new RentalColumnInfo(schemaInfo);
    }

    public static String getSimpleClassName() {
        return "Rental";
    }

    public static final class ClassNameHelper {
        public static final String INTERNAL_CLASS_NAME = "Rental";
    }

    @SuppressWarnings("cast")
    public static csci81.demo.finalproject.realm.Rental createOrUpdateUsingJsonObject(Realm realm, JSONObject json, boolean update)
        throws JSONException {
        final List<String> excludeFields = Collections.<String> emptyList();
        csci81.demo.finalproject.realm.Rental obj = null;
        if (update) {
            Table table = realm.getTable(csci81.demo.finalproject.realm.Rental.class);
            RentalColumnInfo columnInfo = (RentalColumnInfo) realm.getSchema().getColumnInfo(csci81.demo.finalproject.realm.Rental.class);
            long pkColumnKey = columnInfo.rentalIDColKey;
            long objKey = Table.NO_MATCH;
            if (json.isNull("rentalID")) {
                objKey = table.findFirstNull(pkColumnKey);
            } else {
                objKey = table.findFirstString(pkColumnKey, json.getString("rentalID"));
            }
            if (objKey != Table.NO_MATCH) {
                final BaseRealm.RealmObjectContext objectContext = BaseRealm.objectContext.get();
                try {
                    objectContext.set(realm, table.getUncheckedRow(objKey), realm.getSchema().getColumnInfo(csci81.demo.finalproject.realm.Rental.class), false, Collections.<String> emptyList());
                    obj = new io.realm.csci81_demo_finalproject_realm_RentalRealmProxy();
                } finally {
                    objectContext.clear();
                }
            }
        }
        if (obj == null) {
            if (json.has("rentalID")) {
                if (json.isNull("rentalID")) {
                    obj = (io.realm.csci81_demo_finalproject_realm_RentalRealmProxy) realm.createObjectInternal(csci81.demo.finalproject.realm.Rental.class, null, true, excludeFields);
                } else {
                    obj = (io.realm.csci81_demo_finalproject_realm_RentalRealmProxy) realm.createObjectInternal(csci81.demo.finalproject.realm.Rental.class, json.getString("rentalID"), true, excludeFields);
                }
            } else {
                throw new IllegalArgumentException("JSON object doesn't have the primary key field 'rentalID'.");
            }
        }

        final csci81_demo_finalproject_realm_RentalRealmProxyInterface objProxy = (csci81_demo_finalproject_realm_RentalRealmProxyInterface) obj;
        if (json.has("transactionID")) {
            if (json.isNull("transactionID")) {
                objProxy.realmSet$transactionID(null);
            } else {
                objProxy.realmSet$transactionID((String) json.getString("transactionID"));
            }
        }
        if (json.has("userID")) {
            if (json.isNull("userID")) {
                objProxy.realmSet$userID(null);
            } else {
                objProxy.realmSet$userID((String) json.getString("userID"));
            }
        }
        if (json.has("movieID")) {
            if (json.isNull("movieID")) {
                objProxy.realmSet$movieID(null);
            } else {
                objProxy.realmSet$movieID((String) json.getString("movieID"));
            }
        }
        if (json.has("status")) {
            if (json.isNull("status")) {
                objProxy.realmSet$status(null);
            } else {
                objProxy.realmSet$status((String) json.getString("status"));
            }
        }
        if (json.has("rentalDate")) {
            if (json.isNull("rentalDate")) {
                objProxy.realmSet$rentalDate(null);
            } else {
                objProxy.realmSet$rentalDate((String) json.getString("rentalDate"));
            }
        }
        if (json.has("returnDate")) {
            if (json.isNull("returnDate")) {
                objProxy.realmSet$returnDate(null);
            } else {
                objProxy.realmSet$returnDate((String) json.getString("returnDate"));
            }
        }
        if (json.has("quantity")) {
            if (json.isNull("quantity")) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'quantity' to null.");
            } else {
                objProxy.realmSet$quantity((int) json.getInt("quantity"));
            }
        }
        return obj;
    }

    @SuppressWarnings("cast")
    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    public static csci81.demo.finalproject.realm.Rental createUsingJsonStream(Realm realm, JsonReader reader)
        throws IOException {
        boolean jsonHasPrimaryKey = false;
        final csci81.demo.finalproject.realm.Rental obj = new csci81.demo.finalproject.realm.Rental();
        final csci81_demo_finalproject_realm_RentalRealmProxyInterface objProxy = (csci81_demo_finalproject_realm_RentalRealmProxyInterface) obj;
        reader.beginObject();
        while (reader.hasNext()) {
            String name = reader.nextName();
            if (false) {
            } else if (name.equals("rentalID")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$rentalID((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$rentalID(null);
                }
                jsonHasPrimaryKey = true;
            } else if (name.equals("transactionID")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$transactionID((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$transactionID(null);
                }
            } else if (name.equals("userID")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$userID((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$userID(null);
                }
            } else if (name.equals("movieID")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$movieID((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$movieID(null);
                }
            } else if (name.equals("status")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$status((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$status(null);
                }
            } else if (name.equals("rentalDate")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$rentalDate((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$rentalDate(null);
                }
            } else if (name.equals("returnDate")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$returnDate((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$returnDate(null);
                }
            } else if (name.equals("quantity")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$quantity((int) reader.nextInt());
                } else {
                    reader.skipValue();
                    throw new IllegalArgumentException("Trying to set non-nullable field 'quantity' to null.");
                }
            } else {
                reader.skipValue();
            }
        }
        reader.endObject();
        if (!jsonHasPrimaryKey) {
            throw new IllegalArgumentException("JSON object doesn't have the primary key field 'rentalID'.");
        }
        return realm.copyToRealmOrUpdate(obj);
    }

    static csci81_demo_finalproject_realm_RentalRealmProxy newProxyInstance(BaseRealm realm, Row row) {
        // Ignore default values to avoid creating unexpected objects from RealmModel/RealmList fields
        final BaseRealm.RealmObjectContext objectContext = BaseRealm.objectContext.get();
        objectContext.set(realm, row, realm.getSchema().getColumnInfo(csci81.demo.finalproject.realm.Rental.class), false, Collections.<String>emptyList());
        io.realm.csci81_demo_finalproject_realm_RentalRealmProxy obj = new io.realm.csci81_demo_finalproject_realm_RentalRealmProxy();
        objectContext.clear();
        return obj;
    }

    public static csci81.demo.finalproject.realm.Rental copyOrUpdate(Realm realm, RentalColumnInfo columnInfo, csci81.demo.finalproject.realm.Rental object, boolean update, Map<RealmModel,RealmObjectProxy> cache, Set<ImportFlag> flags) {
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
            return (csci81.demo.finalproject.realm.Rental) cachedRealmObject;
        }

        csci81.demo.finalproject.realm.Rental realmObject = null;
        boolean canUpdate = update;
        if (canUpdate) {
            Table table = realm.getTable(csci81.demo.finalproject.realm.Rental.class);
            long pkColumnKey = columnInfo.rentalIDColKey;
            String value = ((csci81_demo_finalproject_realm_RentalRealmProxyInterface) object).realmGet$rentalID();
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
                    realmObject = new io.realm.csci81_demo_finalproject_realm_RentalRealmProxy();
                    cache.put(object, (RealmObjectProxy) realmObject);
                } finally {
                    objectContext.clear();
                }
            }
        }

        return (canUpdate) ? update(realm, columnInfo, realmObject, object, cache, flags) : copy(realm, columnInfo, object, update, cache, flags);
    }

    public static csci81.demo.finalproject.realm.Rental copy(Realm realm, RentalColumnInfo columnInfo, csci81.demo.finalproject.realm.Rental newObject, boolean update, Map<RealmModel,RealmObjectProxy> cache, Set<ImportFlag> flags) {
        RealmObjectProxy cachedRealmObject = cache.get(newObject);
        if (cachedRealmObject != null) {
            return (csci81.demo.finalproject.realm.Rental) cachedRealmObject;
        }

        csci81_demo_finalproject_realm_RentalRealmProxyInterface unmanagedSource = (csci81_demo_finalproject_realm_RentalRealmProxyInterface) newObject;

        Table table = realm.getTable(csci81.demo.finalproject.realm.Rental.class);
        OsObjectBuilder builder = new OsObjectBuilder(table, flags);

        // Add all non-"object reference" fields
        builder.addString(columnInfo.rentalIDColKey, unmanagedSource.realmGet$rentalID());
        builder.addString(columnInfo.transactionIDColKey, unmanagedSource.realmGet$transactionID());
        builder.addString(columnInfo.userIDColKey, unmanagedSource.realmGet$userID());
        builder.addString(columnInfo.movieIDColKey, unmanagedSource.realmGet$movieID());
        builder.addString(columnInfo.statusColKey, unmanagedSource.realmGet$status());
        builder.addString(columnInfo.rentalDateColKey, unmanagedSource.realmGet$rentalDate());
        builder.addString(columnInfo.returnDateColKey, unmanagedSource.realmGet$returnDate());
        builder.addInteger(columnInfo.quantityColKey, unmanagedSource.realmGet$quantity());

        // Create the underlying object and cache it before setting any object/objectlist references
        // This will allow us to break any circular dependencies by using the object cache.
        Row row = builder.createNewObject();
        io.realm.csci81_demo_finalproject_realm_RentalRealmProxy managedCopy = newProxyInstance(realm, row);
        cache.put(newObject, managedCopy);

        return managedCopy;
    }

    public static long insert(Realm realm, csci81.demo.finalproject.realm.Rental object, Map<RealmModel,Long> cache) {
        if (object instanceof RealmObjectProxy && !RealmObject.isFrozen(object) && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getObjectKey();
        }
        Table table = realm.getTable(csci81.demo.finalproject.realm.Rental.class);
        long tableNativePtr = table.getNativePtr();
        RentalColumnInfo columnInfo = (RentalColumnInfo) realm.getSchema().getColumnInfo(csci81.demo.finalproject.realm.Rental.class);
        long pkColumnKey = columnInfo.rentalIDColKey;
        String primaryKeyValue = ((csci81_demo_finalproject_realm_RentalRealmProxyInterface) object).realmGet$rentalID();
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
        String realmGet$transactionID = ((csci81_demo_finalproject_realm_RentalRealmProxyInterface) object).realmGet$transactionID();
        if (realmGet$transactionID != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.transactionIDColKey, objKey, realmGet$transactionID, false);
        }
        String realmGet$userID = ((csci81_demo_finalproject_realm_RentalRealmProxyInterface) object).realmGet$userID();
        if (realmGet$userID != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.userIDColKey, objKey, realmGet$userID, false);
        }
        String realmGet$movieID = ((csci81_demo_finalproject_realm_RentalRealmProxyInterface) object).realmGet$movieID();
        if (realmGet$movieID != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.movieIDColKey, objKey, realmGet$movieID, false);
        }
        String realmGet$status = ((csci81_demo_finalproject_realm_RentalRealmProxyInterface) object).realmGet$status();
        if (realmGet$status != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.statusColKey, objKey, realmGet$status, false);
        }
        String realmGet$rentalDate = ((csci81_demo_finalproject_realm_RentalRealmProxyInterface) object).realmGet$rentalDate();
        if (realmGet$rentalDate != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.rentalDateColKey, objKey, realmGet$rentalDate, false);
        }
        String realmGet$returnDate = ((csci81_demo_finalproject_realm_RentalRealmProxyInterface) object).realmGet$returnDate();
        if (realmGet$returnDate != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.returnDateColKey, objKey, realmGet$returnDate, false);
        }
        Table.nativeSetLong(tableNativePtr, columnInfo.quantityColKey, objKey, ((csci81_demo_finalproject_realm_RentalRealmProxyInterface) object).realmGet$quantity(), false);
        return objKey;
    }

    public static void insert(Realm realm, Iterator<? extends RealmModel> objects, Map<RealmModel,Long> cache) {
        Table table = realm.getTable(csci81.demo.finalproject.realm.Rental.class);
        long tableNativePtr = table.getNativePtr();
        RentalColumnInfo columnInfo = (RentalColumnInfo) realm.getSchema().getColumnInfo(csci81.demo.finalproject.realm.Rental.class);
        long pkColumnKey = columnInfo.rentalIDColKey;
        csci81.demo.finalproject.realm.Rental object = null;
        while (objects.hasNext()) {
            object = (csci81.demo.finalproject.realm.Rental) objects.next();
            if (cache.containsKey(object)) {
                continue;
            }
            if (object instanceof RealmObjectProxy && !RealmObject.isFrozen(object) && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                cache.put(object, ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getObjectKey());
                continue;
            }
            String primaryKeyValue = ((csci81_demo_finalproject_realm_RentalRealmProxyInterface) object).realmGet$rentalID();
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
            String realmGet$transactionID = ((csci81_demo_finalproject_realm_RentalRealmProxyInterface) object).realmGet$transactionID();
            if (realmGet$transactionID != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.transactionIDColKey, objKey, realmGet$transactionID, false);
            }
            String realmGet$userID = ((csci81_demo_finalproject_realm_RentalRealmProxyInterface) object).realmGet$userID();
            if (realmGet$userID != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.userIDColKey, objKey, realmGet$userID, false);
            }
            String realmGet$movieID = ((csci81_demo_finalproject_realm_RentalRealmProxyInterface) object).realmGet$movieID();
            if (realmGet$movieID != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.movieIDColKey, objKey, realmGet$movieID, false);
            }
            String realmGet$status = ((csci81_demo_finalproject_realm_RentalRealmProxyInterface) object).realmGet$status();
            if (realmGet$status != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.statusColKey, objKey, realmGet$status, false);
            }
            String realmGet$rentalDate = ((csci81_demo_finalproject_realm_RentalRealmProxyInterface) object).realmGet$rentalDate();
            if (realmGet$rentalDate != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.rentalDateColKey, objKey, realmGet$rentalDate, false);
            }
            String realmGet$returnDate = ((csci81_demo_finalproject_realm_RentalRealmProxyInterface) object).realmGet$returnDate();
            if (realmGet$returnDate != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.returnDateColKey, objKey, realmGet$returnDate, false);
            }
            Table.nativeSetLong(tableNativePtr, columnInfo.quantityColKey, objKey, ((csci81_demo_finalproject_realm_RentalRealmProxyInterface) object).realmGet$quantity(), false);
        }
    }

    public static long insertOrUpdate(Realm realm, csci81.demo.finalproject.realm.Rental object, Map<RealmModel,Long> cache) {
        if (object instanceof RealmObjectProxy && !RealmObject.isFrozen(object) && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getObjectKey();
        }
        Table table = realm.getTable(csci81.demo.finalproject.realm.Rental.class);
        long tableNativePtr = table.getNativePtr();
        RentalColumnInfo columnInfo = (RentalColumnInfo) realm.getSchema().getColumnInfo(csci81.demo.finalproject.realm.Rental.class);
        long pkColumnKey = columnInfo.rentalIDColKey;
        String primaryKeyValue = ((csci81_demo_finalproject_realm_RentalRealmProxyInterface) object).realmGet$rentalID();
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
        String realmGet$transactionID = ((csci81_demo_finalproject_realm_RentalRealmProxyInterface) object).realmGet$transactionID();
        if (realmGet$transactionID != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.transactionIDColKey, objKey, realmGet$transactionID, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.transactionIDColKey, objKey, false);
        }
        String realmGet$userID = ((csci81_demo_finalproject_realm_RentalRealmProxyInterface) object).realmGet$userID();
        if (realmGet$userID != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.userIDColKey, objKey, realmGet$userID, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.userIDColKey, objKey, false);
        }
        String realmGet$movieID = ((csci81_demo_finalproject_realm_RentalRealmProxyInterface) object).realmGet$movieID();
        if (realmGet$movieID != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.movieIDColKey, objKey, realmGet$movieID, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.movieIDColKey, objKey, false);
        }
        String realmGet$status = ((csci81_demo_finalproject_realm_RentalRealmProxyInterface) object).realmGet$status();
        if (realmGet$status != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.statusColKey, objKey, realmGet$status, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.statusColKey, objKey, false);
        }
        String realmGet$rentalDate = ((csci81_demo_finalproject_realm_RentalRealmProxyInterface) object).realmGet$rentalDate();
        if (realmGet$rentalDate != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.rentalDateColKey, objKey, realmGet$rentalDate, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.rentalDateColKey, objKey, false);
        }
        String realmGet$returnDate = ((csci81_demo_finalproject_realm_RentalRealmProxyInterface) object).realmGet$returnDate();
        if (realmGet$returnDate != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.returnDateColKey, objKey, realmGet$returnDate, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.returnDateColKey, objKey, false);
        }
        Table.nativeSetLong(tableNativePtr, columnInfo.quantityColKey, objKey, ((csci81_demo_finalproject_realm_RentalRealmProxyInterface) object).realmGet$quantity(), false);
        return objKey;
    }

    public static void insertOrUpdate(Realm realm, Iterator<? extends RealmModel> objects, Map<RealmModel,Long> cache) {
        Table table = realm.getTable(csci81.demo.finalproject.realm.Rental.class);
        long tableNativePtr = table.getNativePtr();
        RentalColumnInfo columnInfo = (RentalColumnInfo) realm.getSchema().getColumnInfo(csci81.demo.finalproject.realm.Rental.class);
        long pkColumnKey = columnInfo.rentalIDColKey;
        csci81.demo.finalproject.realm.Rental object = null;
        while (objects.hasNext()) {
            object = (csci81.demo.finalproject.realm.Rental) objects.next();
            if (cache.containsKey(object)) {
                continue;
            }
            if (object instanceof RealmObjectProxy && !RealmObject.isFrozen(object) && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                cache.put(object, ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getObjectKey());
                continue;
            }
            String primaryKeyValue = ((csci81_demo_finalproject_realm_RentalRealmProxyInterface) object).realmGet$rentalID();
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
            String realmGet$transactionID = ((csci81_demo_finalproject_realm_RentalRealmProxyInterface) object).realmGet$transactionID();
            if (realmGet$transactionID != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.transactionIDColKey, objKey, realmGet$transactionID, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.transactionIDColKey, objKey, false);
            }
            String realmGet$userID = ((csci81_demo_finalproject_realm_RentalRealmProxyInterface) object).realmGet$userID();
            if (realmGet$userID != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.userIDColKey, objKey, realmGet$userID, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.userIDColKey, objKey, false);
            }
            String realmGet$movieID = ((csci81_demo_finalproject_realm_RentalRealmProxyInterface) object).realmGet$movieID();
            if (realmGet$movieID != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.movieIDColKey, objKey, realmGet$movieID, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.movieIDColKey, objKey, false);
            }
            String realmGet$status = ((csci81_demo_finalproject_realm_RentalRealmProxyInterface) object).realmGet$status();
            if (realmGet$status != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.statusColKey, objKey, realmGet$status, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.statusColKey, objKey, false);
            }
            String realmGet$rentalDate = ((csci81_demo_finalproject_realm_RentalRealmProxyInterface) object).realmGet$rentalDate();
            if (realmGet$rentalDate != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.rentalDateColKey, objKey, realmGet$rentalDate, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.rentalDateColKey, objKey, false);
            }
            String realmGet$returnDate = ((csci81_demo_finalproject_realm_RentalRealmProxyInterface) object).realmGet$returnDate();
            if (realmGet$returnDate != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.returnDateColKey, objKey, realmGet$returnDate, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.returnDateColKey, objKey, false);
            }
            Table.nativeSetLong(tableNativePtr, columnInfo.quantityColKey, objKey, ((csci81_demo_finalproject_realm_RentalRealmProxyInterface) object).realmGet$quantity(), false);
        }
    }

    public static csci81.demo.finalproject.realm.Rental createDetachedCopy(csci81.demo.finalproject.realm.Rental realmObject, int currentDepth, int maxDepth, Map<RealmModel, CacheData<RealmModel>> cache) {
        if (currentDepth > maxDepth || realmObject == null) {
            return null;
        }
        CacheData<RealmModel> cachedObject = cache.get(realmObject);
        csci81.demo.finalproject.realm.Rental unmanagedObject;
        if (cachedObject == null) {
            unmanagedObject = new csci81.demo.finalproject.realm.Rental();
            cache.put(realmObject, new RealmObjectProxy.CacheData<RealmModel>(currentDepth, unmanagedObject));
        } else {
            // Reuse cached object or recreate it because it was encountered at a lower depth.
            if (currentDepth >= cachedObject.minDepth) {
                return (csci81.demo.finalproject.realm.Rental) cachedObject.object;
            }
            unmanagedObject = (csci81.demo.finalproject.realm.Rental) cachedObject.object;
            cachedObject.minDepth = currentDepth;
        }
        csci81_demo_finalproject_realm_RentalRealmProxyInterface unmanagedCopy = (csci81_demo_finalproject_realm_RentalRealmProxyInterface) unmanagedObject;
        csci81_demo_finalproject_realm_RentalRealmProxyInterface realmSource = (csci81_demo_finalproject_realm_RentalRealmProxyInterface) realmObject;
        Realm objectRealm = (Realm) ((RealmObjectProxy) realmObject).realmGet$proxyState().getRealm$realm();
        unmanagedCopy.realmSet$rentalID(realmSource.realmGet$rentalID());
        unmanagedCopy.realmSet$transactionID(realmSource.realmGet$transactionID());
        unmanagedCopy.realmSet$userID(realmSource.realmGet$userID());
        unmanagedCopy.realmSet$movieID(realmSource.realmGet$movieID());
        unmanagedCopy.realmSet$status(realmSource.realmGet$status());
        unmanagedCopy.realmSet$rentalDate(realmSource.realmGet$rentalDate());
        unmanagedCopy.realmSet$returnDate(realmSource.realmGet$returnDate());
        unmanagedCopy.realmSet$quantity(realmSource.realmGet$quantity());

        return unmanagedObject;
    }

    static csci81.demo.finalproject.realm.Rental update(Realm realm, RentalColumnInfo columnInfo, csci81.demo.finalproject.realm.Rental realmObject, csci81.demo.finalproject.realm.Rental newObject, Map<RealmModel, RealmObjectProxy> cache, Set<ImportFlag> flags) {
        csci81_demo_finalproject_realm_RentalRealmProxyInterface realmObjectTarget = (csci81_demo_finalproject_realm_RentalRealmProxyInterface) realmObject;
        csci81_demo_finalproject_realm_RentalRealmProxyInterface realmObjectSource = (csci81_demo_finalproject_realm_RentalRealmProxyInterface) newObject;
        Table table = realm.getTable(csci81.demo.finalproject.realm.Rental.class);
        OsObjectBuilder builder = new OsObjectBuilder(table, flags);
        builder.addString(columnInfo.rentalIDColKey, realmObjectSource.realmGet$rentalID());
        builder.addString(columnInfo.transactionIDColKey, realmObjectSource.realmGet$transactionID());
        builder.addString(columnInfo.userIDColKey, realmObjectSource.realmGet$userID());
        builder.addString(columnInfo.movieIDColKey, realmObjectSource.realmGet$movieID());
        builder.addString(columnInfo.statusColKey, realmObjectSource.realmGet$status());
        builder.addString(columnInfo.rentalDateColKey, realmObjectSource.realmGet$rentalDate());
        builder.addString(columnInfo.returnDateColKey, realmObjectSource.realmGet$returnDate());
        builder.addInteger(columnInfo.quantityColKey, realmObjectSource.realmGet$quantity());

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
        csci81_demo_finalproject_realm_RentalRealmProxy aRental = (csci81_demo_finalproject_realm_RentalRealmProxy)o;

        BaseRealm realm = proxyState.getRealm$realm();
        BaseRealm otherRealm = aRental.proxyState.getRealm$realm();
        String path = realm.getPath();
        String otherPath = otherRealm.getPath();
        if (path != null ? !path.equals(otherPath) : otherPath != null) return false;
        if (realm.isFrozen() != otherRealm.isFrozen()) return false;
        if (!realm.sharedRealm.getVersionID().equals(otherRealm.sharedRealm.getVersionID())) {
            return false;
        }

        String tableName = proxyState.getRow$realm().getTable().getName();
        String otherTableName = aRental.proxyState.getRow$realm().getTable().getName();
        if (tableName != null ? !tableName.equals(otherTableName) : otherTableName != null) return false;

        if (proxyState.getRow$realm().getObjectKey() != aRental.proxyState.getRow$realm().getObjectKey()) return false;

        return true;
    }
}
