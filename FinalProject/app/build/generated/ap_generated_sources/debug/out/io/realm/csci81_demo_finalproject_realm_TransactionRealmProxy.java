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
public class csci81_demo_finalproject_realm_TransactionRealmProxy extends csci81.demo.finalproject.realm.Transaction
    implements RealmObjectProxy, csci81_demo_finalproject_realm_TransactionRealmProxyInterface {

    static final class TransactionColumnInfo extends ColumnInfo {
        long transactionIDColKey;
        long rentalIDColKey;
        long userIDColKey;
        long amountColKey;
        long transactionDateColKey;

        TransactionColumnInfo(OsSchemaInfo schemaInfo) {
            super(5);
            OsObjectSchemaInfo objectSchemaInfo = schemaInfo.getObjectSchemaInfo("Transaction");
            this.transactionIDColKey = addColumnDetails("transactionID", "transactionID", objectSchemaInfo);
            this.rentalIDColKey = addColumnDetails("rentalID", "rentalID", objectSchemaInfo);
            this.userIDColKey = addColumnDetails("userID", "userID", objectSchemaInfo);
            this.amountColKey = addColumnDetails("amount", "amount", objectSchemaInfo);
            this.transactionDateColKey = addColumnDetails("transactionDate", "transactionDate", objectSchemaInfo);
        }

        TransactionColumnInfo(ColumnInfo src, boolean mutable) {
            super(src, mutable);
            copy(src, this);
        }

        @Override
        protected final ColumnInfo copy(boolean mutable) {
            return new TransactionColumnInfo(this, mutable);
        }

        @Override
        protected final void copy(ColumnInfo rawSrc, ColumnInfo rawDst) {
            final TransactionColumnInfo src = (TransactionColumnInfo) rawSrc;
            final TransactionColumnInfo dst = (TransactionColumnInfo) rawDst;
            dst.transactionIDColKey = src.transactionIDColKey;
            dst.rentalIDColKey = src.rentalIDColKey;
            dst.userIDColKey = src.userIDColKey;
            dst.amountColKey = src.amountColKey;
            dst.transactionDateColKey = src.transactionDateColKey;
        }
    }

    private static final String NO_ALIAS = "";
    private static final OsObjectSchemaInfo expectedObjectSchemaInfo = createExpectedObjectSchemaInfo();

    private TransactionColumnInfo columnInfo;
    private ProxyState<csci81.demo.finalproject.realm.Transaction> proxyState;

    csci81_demo_finalproject_realm_TransactionRealmProxy() {
        proxyState.setConstructionFinished();
    }

    @Override
    public void realm$injectObjectContext() {
        if (this.proxyState != null) {
            return;
        }
        final BaseRealm.RealmObjectContext context = BaseRealm.objectContext.get();
        this.columnInfo = (TransactionColumnInfo) context.getColumnInfo();
        this.proxyState = new ProxyState<csci81.demo.finalproject.realm.Transaction>(this);
        proxyState.setRealm$realm(context.getRealm());
        proxyState.setRow$realm(context.getRow());
        proxyState.setAcceptDefaultValue$realm(context.getAcceptDefaultValue());
        proxyState.setExcludeFields$realm(context.getExcludeFields());
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
            // default value of the primary key is always ignored.
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        throw new io.realm.exceptions.RealmException("Primary key field 'transactionID' cannot be changed after object was created.");
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
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.rentalIDColKey, row.getObjectKey(), true);
                return;
            }
            row.getTable().setString(columnInfo.rentalIDColKey, row.getObjectKey(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.rentalIDColKey);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.rentalIDColKey, value);
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
    public int realmGet$amount() {
        proxyState.getRealm$realm().checkIfValid();
        return (int) proxyState.getRow$realm().getLong(columnInfo.amountColKey);
    }

    @Override
    public void realmSet$amount(int value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            row.getTable().setLong(columnInfo.amountColKey, row.getObjectKey(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        proxyState.getRow$realm().setLong(columnInfo.amountColKey, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$transactionDate() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.transactionDateColKey);
    }

    @Override
    public void realmSet$transactionDate(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.transactionDateColKey, row.getObjectKey(), true);
                return;
            }
            row.getTable().setString(columnInfo.transactionDateColKey, row.getObjectKey(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.transactionDateColKey);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.transactionDateColKey, value);
    }

    private static OsObjectSchemaInfo createExpectedObjectSchemaInfo() {
        OsObjectSchemaInfo.Builder builder = new OsObjectSchemaInfo.Builder(NO_ALIAS, "Transaction", false, 5, 0);
        builder.addPersistedProperty(NO_ALIAS, "transactionID", RealmFieldType.STRING, Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty(NO_ALIAS, "rentalID", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty(NO_ALIAS, "userID", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty(NO_ALIAS, "amount", RealmFieldType.INTEGER, !Property.PRIMARY_KEY, !Property.INDEXED, Property.REQUIRED);
        builder.addPersistedProperty(NO_ALIAS, "transactionDate", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        return builder.build();
    }

    public static OsObjectSchemaInfo getExpectedObjectSchemaInfo() {
        return expectedObjectSchemaInfo;
    }

    public static TransactionColumnInfo createColumnInfo(OsSchemaInfo schemaInfo) {
        return new TransactionColumnInfo(schemaInfo);
    }

    public static String getSimpleClassName() {
        return "Transaction";
    }

    public static final class ClassNameHelper {
        public static final String INTERNAL_CLASS_NAME = "Transaction";
    }

    @SuppressWarnings("cast")
    public static csci81.demo.finalproject.realm.Transaction createOrUpdateUsingJsonObject(Realm realm, JSONObject json, boolean update)
        throws JSONException {
        final List<String> excludeFields = Collections.<String> emptyList();
        csci81.demo.finalproject.realm.Transaction obj = null;
        if (update) {
            Table table = realm.getTable(csci81.demo.finalproject.realm.Transaction.class);
            TransactionColumnInfo columnInfo = (TransactionColumnInfo) realm.getSchema().getColumnInfo(csci81.demo.finalproject.realm.Transaction.class);
            long pkColumnKey = columnInfo.transactionIDColKey;
            long objKey = Table.NO_MATCH;
            if (json.isNull("transactionID")) {
                objKey = table.findFirstNull(pkColumnKey);
            } else {
                objKey = table.findFirstString(pkColumnKey, json.getString("transactionID"));
            }
            if (objKey != Table.NO_MATCH) {
                final BaseRealm.RealmObjectContext objectContext = BaseRealm.objectContext.get();
                try {
                    objectContext.set(realm, table.getUncheckedRow(objKey), realm.getSchema().getColumnInfo(csci81.demo.finalproject.realm.Transaction.class), false, Collections.<String> emptyList());
                    obj = new io.realm.csci81_demo_finalproject_realm_TransactionRealmProxy();
                } finally {
                    objectContext.clear();
                }
            }
        }
        if (obj == null) {
            if (json.has("transactionID")) {
                if (json.isNull("transactionID")) {
                    obj = (io.realm.csci81_demo_finalproject_realm_TransactionRealmProxy) realm.createObjectInternal(csci81.demo.finalproject.realm.Transaction.class, null, true, excludeFields);
                } else {
                    obj = (io.realm.csci81_demo_finalproject_realm_TransactionRealmProxy) realm.createObjectInternal(csci81.demo.finalproject.realm.Transaction.class, json.getString("transactionID"), true, excludeFields);
                }
            } else {
                throw new IllegalArgumentException("JSON object doesn't have the primary key field 'transactionID'.");
            }
        }

        final csci81_demo_finalproject_realm_TransactionRealmProxyInterface objProxy = (csci81_demo_finalproject_realm_TransactionRealmProxyInterface) obj;
        if (json.has("rentalID")) {
            if (json.isNull("rentalID")) {
                objProxy.realmSet$rentalID(null);
            } else {
                objProxy.realmSet$rentalID((String) json.getString("rentalID"));
            }
        }
        if (json.has("userID")) {
            if (json.isNull("userID")) {
                objProxy.realmSet$userID(null);
            } else {
                objProxy.realmSet$userID((String) json.getString("userID"));
            }
        }
        if (json.has("amount")) {
            if (json.isNull("amount")) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'amount' to null.");
            } else {
                objProxy.realmSet$amount((int) json.getInt("amount"));
            }
        }
        if (json.has("transactionDate")) {
            if (json.isNull("transactionDate")) {
                objProxy.realmSet$transactionDate(null);
            } else {
                objProxy.realmSet$transactionDate((String) json.getString("transactionDate"));
            }
        }
        return obj;
    }

    @SuppressWarnings("cast")
    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    public static csci81.demo.finalproject.realm.Transaction createUsingJsonStream(Realm realm, JsonReader reader)
        throws IOException {
        boolean jsonHasPrimaryKey = false;
        final csci81.demo.finalproject.realm.Transaction obj = new csci81.demo.finalproject.realm.Transaction();
        final csci81_demo_finalproject_realm_TransactionRealmProxyInterface objProxy = (csci81_demo_finalproject_realm_TransactionRealmProxyInterface) obj;
        reader.beginObject();
        while (reader.hasNext()) {
            String name = reader.nextName();
            if (false) {
            } else if (name.equals("transactionID")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$transactionID((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$transactionID(null);
                }
                jsonHasPrimaryKey = true;
            } else if (name.equals("rentalID")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$rentalID((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$rentalID(null);
                }
            } else if (name.equals("userID")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$userID((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$userID(null);
                }
            } else if (name.equals("amount")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$amount((int) reader.nextInt());
                } else {
                    reader.skipValue();
                    throw new IllegalArgumentException("Trying to set non-nullable field 'amount' to null.");
                }
            } else if (name.equals("transactionDate")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$transactionDate((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$transactionDate(null);
                }
            } else {
                reader.skipValue();
            }
        }
        reader.endObject();
        if (!jsonHasPrimaryKey) {
            throw new IllegalArgumentException("JSON object doesn't have the primary key field 'transactionID'.");
        }
        return realm.copyToRealmOrUpdate(obj);
    }

    static csci81_demo_finalproject_realm_TransactionRealmProxy newProxyInstance(BaseRealm realm, Row row) {
        // Ignore default values to avoid creating unexpected objects from RealmModel/RealmList fields
        final BaseRealm.RealmObjectContext objectContext = BaseRealm.objectContext.get();
        objectContext.set(realm, row, realm.getSchema().getColumnInfo(csci81.demo.finalproject.realm.Transaction.class), false, Collections.<String>emptyList());
        io.realm.csci81_demo_finalproject_realm_TransactionRealmProxy obj = new io.realm.csci81_demo_finalproject_realm_TransactionRealmProxy();
        objectContext.clear();
        return obj;
    }

    public static csci81.demo.finalproject.realm.Transaction copyOrUpdate(Realm realm, TransactionColumnInfo columnInfo, csci81.demo.finalproject.realm.Transaction object, boolean update, Map<RealmModel,RealmObjectProxy> cache, Set<ImportFlag> flags) {
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
            return (csci81.demo.finalproject.realm.Transaction) cachedRealmObject;
        }

        csci81.demo.finalproject.realm.Transaction realmObject = null;
        boolean canUpdate = update;
        if (canUpdate) {
            Table table = realm.getTable(csci81.demo.finalproject.realm.Transaction.class);
            long pkColumnKey = columnInfo.transactionIDColKey;
            String value = ((csci81_demo_finalproject_realm_TransactionRealmProxyInterface) object).realmGet$transactionID();
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
                    realmObject = new io.realm.csci81_demo_finalproject_realm_TransactionRealmProxy();
                    cache.put(object, (RealmObjectProxy) realmObject);
                } finally {
                    objectContext.clear();
                }
            }
        }

        return (canUpdate) ? update(realm, columnInfo, realmObject, object, cache, flags) : copy(realm, columnInfo, object, update, cache, flags);
    }

    public static csci81.demo.finalproject.realm.Transaction copy(Realm realm, TransactionColumnInfo columnInfo, csci81.demo.finalproject.realm.Transaction newObject, boolean update, Map<RealmModel,RealmObjectProxy> cache, Set<ImportFlag> flags) {
        RealmObjectProxy cachedRealmObject = cache.get(newObject);
        if (cachedRealmObject != null) {
            return (csci81.demo.finalproject.realm.Transaction) cachedRealmObject;
        }

        csci81_demo_finalproject_realm_TransactionRealmProxyInterface unmanagedSource = (csci81_demo_finalproject_realm_TransactionRealmProxyInterface) newObject;

        Table table = realm.getTable(csci81.demo.finalproject.realm.Transaction.class);
        OsObjectBuilder builder = new OsObjectBuilder(table, flags);

        // Add all non-"object reference" fields
        builder.addString(columnInfo.transactionIDColKey, unmanagedSource.realmGet$transactionID());
        builder.addString(columnInfo.rentalIDColKey, unmanagedSource.realmGet$rentalID());
        builder.addString(columnInfo.userIDColKey, unmanagedSource.realmGet$userID());
        builder.addInteger(columnInfo.amountColKey, unmanagedSource.realmGet$amount());
        builder.addString(columnInfo.transactionDateColKey, unmanagedSource.realmGet$transactionDate());

        // Create the underlying object and cache it before setting any object/objectlist references
        // This will allow us to break any circular dependencies by using the object cache.
        Row row = builder.createNewObject();
        io.realm.csci81_demo_finalproject_realm_TransactionRealmProxy managedCopy = newProxyInstance(realm, row);
        cache.put(newObject, managedCopy);

        return managedCopy;
    }

    public static long insert(Realm realm, csci81.demo.finalproject.realm.Transaction object, Map<RealmModel,Long> cache) {
        if (object instanceof RealmObjectProxy && !RealmObject.isFrozen(object) && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getObjectKey();
        }
        Table table = realm.getTable(csci81.demo.finalproject.realm.Transaction.class);
        long tableNativePtr = table.getNativePtr();
        TransactionColumnInfo columnInfo = (TransactionColumnInfo) realm.getSchema().getColumnInfo(csci81.demo.finalproject.realm.Transaction.class);
        long pkColumnKey = columnInfo.transactionIDColKey;
        String primaryKeyValue = ((csci81_demo_finalproject_realm_TransactionRealmProxyInterface) object).realmGet$transactionID();
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
        String realmGet$rentalID = ((csci81_demo_finalproject_realm_TransactionRealmProxyInterface) object).realmGet$rentalID();
        if (realmGet$rentalID != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.rentalIDColKey, objKey, realmGet$rentalID, false);
        }
        String realmGet$userID = ((csci81_demo_finalproject_realm_TransactionRealmProxyInterface) object).realmGet$userID();
        if (realmGet$userID != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.userIDColKey, objKey, realmGet$userID, false);
        }
        Table.nativeSetLong(tableNativePtr, columnInfo.amountColKey, objKey, ((csci81_demo_finalproject_realm_TransactionRealmProxyInterface) object).realmGet$amount(), false);
        String realmGet$transactionDate = ((csci81_demo_finalproject_realm_TransactionRealmProxyInterface) object).realmGet$transactionDate();
        if (realmGet$transactionDate != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.transactionDateColKey, objKey, realmGet$transactionDate, false);
        }
        return objKey;
    }

    public static void insert(Realm realm, Iterator<? extends RealmModel> objects, Map<RealmModel,Long> cache) {
        Table table = realm.getTable(csci81.demo.finalproject.realm.Transaction.class);
        long tableNativePtr = table.getNativePtr();
        TransactionColumnInfo columnInfo = (TransactionColumnInfo) realm.getSchema().getColumnInfo(csci81.demo.finalproject.realm.Transaction.class);
        long pkColumnKey = columnInfo.transactionIDColKey;
        csci81.demo.finalproject.realm.Transaction object = null;
        while (objects.hasNext()) {
            object = (csci81.demo.finalproject.realm.Transaction) objects.next();
            if (cache.containsKey(object)) {
                continue;
            }
            if (object instanceof RealmObjectProxy && !RealmObject.isFrozen(object) && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                cache.put(object, ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getObjectKey());
                continue;
            }
            String primaryKeyValue = ((csci81_demo_finalproject_realm_TransactionRealmProxyInterface) object).realmGet$transactionID();
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
            String realmGet$rentalID = ((csci81_demo_finalproject_realm_TransactionRealmProxyInterface) object).realmGet$rentalID();
            if (realmGet$rentalID != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.rentalIDColKey, objKey, realmGet$rentalID, false);
            }
            String realmGet$userID = ((csci81_demo_finalproject_realm_TransactionRealmProxyInterface) object).realmGet$userID();
            if (realmGet$userID != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.userIDColKey, objKey, realmGet$userID, false);
            }
            Table.nativeSetLong(tableNativePtr, columnInfo.amountColKey, objKey, ((csci81_demo_finalproject_realm_TransactionRealmProxyInterface) object).realmGet$amount(), false);
            String realmGet$transactionDate = ((csci81_demo_finalproject_realm_TransactionRealmProxyInterface) object).realmGet$transactionDate();
            if (realmGet$transactionDate != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.transactionDateColKey, objKey, realmGet$transactionDate, false);
            }
        }
    }

    public static long insertOrUpdate(Realm realm, csci81.demo.finalproject.realm.Transaction object, Map<RealmModel,Long> cache) {
        if (object instanceof RealmObjectProxy && !RealmObject.isFrozen(object) && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getObjectKey();
        }
        Table table = realm.getTable(csci81.demo.finalproject.realm.Transaction.class);
        long tableNativePtr = table.getNativePtr();
        TransactionColumnInfo columnInfo = (TransactionColumnInfo) realm.getSchema().getColumnInfo(csci81.demo.finalproject.realm.Transaction.class);
        long pkColumnKey = columnInfo.transactionIDColKey;
        String primaryKeyValue = ((csci81_demo_finalproject_realm_TransactionRealmProxyInterface) object).realmGet$transactionID();
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
        String realmGet$rentalID = ((csci81_demo_finalproject_realm_TransactionRealmProxyInterface) object).realmGet$rentalID();
        if (realmGet$rentalID != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.rentalIDColKey, objKey, realmGet$rentalID, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.rentalIDColKey, objKey, false);
        }
        String realmGet$userID = ((csci81_demo_finalproject_realm_TransactionRealmProxyInterface) object).realmGet$userID();
        if (realmGet$userID != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.userIDColKey, objKey, realmGet$userID, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.userIDColKey, objKey, false);
        }
        Table.nativeSetLong(tableNativePtr, columnInfo.amountColKey, objKey, ((csci81_demo_finalproject_realm_TransactionRealmProxyInterface) object).realmGet$amount(), false);
        String realmGet$transactionDate = ((csci81_demo_finalproject_realm_TransactionRealmProxyInterface) object).realmGet$transactionDate();
        if (realmGet$transactionDate != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.transactionDateColKey, objKey, realmGet$transactionDate, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.transactionDateColKey, objKey, false);
        }
        return objKey;
    }

    public static void insertOrUpdate(Realm realm, Iterator<? extends RealmModel> objects, Map<RealmModel,Long> cache) {
        Table table = realm.getTable(csci81.demo.finalproject.realm.Transaction.class);
        long tableNativePtr = table.getNativePtr();
        TransactionColumnInfo columnInfo = (TransactionColumnInfo) realm.getSchema().getColumnInfo(csci81.demo.finalproject.realm.Transaction.class);
        long pkColumnKey = columnInfo.transactionIDColKey;
        csci81.demo.finalproject.realm.Transaction object = null;
        while (objects.hasNext()) {
            object = (csci81.demo.finalproject.realm.Transaction) objects.next();
            if (cache.containsKey(object)) {
                continue;
            }
            if (object instanceof RealmObjectProxy && !RealmObject.isFrozen(object) && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                cache.put(object, ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getObjectKey());
                continue;
            }
            String primaryKeyValue = ((csci81_demo_finalproject_realm_TransactionRealmProxyInterface) object).realmGet$transactionID();
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
            String realmGet$rentalID = ((csci81_demo_finalproject_realm_TransactionRealmProxyInterface) object).realmGet$rentalID();
            if (realmGet$rentalID != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.rentalIDColKey, objKey, realmGet$rentalID, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.rentalIDColKey, objKey, false);
            }
            String realmGet$userID = ((csci81_demo_finalproject_realm_TransactionRealmProxyInterface) object).realmGet$userID();
            if (realmGet$userID != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.userIDColKey, objKey, realmGet$userID, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.userIDColKey, objKey, false);
            }
            Table.nativeSetLong(tableNativePtr, columnInfo.amountColKey, objKey, ((csci81_demo_finalproject_realm_TransactionRealmProxyInterface) object).realmGet$amount(), false);
            String realmGet$transactionDate = ((csci81_demo_finalproject_realm_TransactionRealmProxyInterface) object).realmGet$transactionDate();
            if (realmGet$transactionDate != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.transactionDateColKey, objKey, realmGet$transactionDate, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.transactionDateColKey, objKey, false);
            }
        }
    }

    public static csci81.demo.finalproject.realm.Transaction createDetachedCopy(csci81.demo.finalproject.realm.Transaction realmObject, int currentDepth, int maxDepth, Map<RealmModel, CacheData<RealmModel>> cache) {
        if (currentDepth > maxDepth || realmObject == null) {
            return null;
        }
        CacheData<RealmModel> cachedObject = cache.get(realmObject);
        csci81.demo.finalproject.realm.Transaction unmanagedObject;
        if (cachedObject == null) {
            unmanagedObject = new csci81.demo.finalproject.realm.Transaction();
            cache.put(realmObject, new RealmObjectProxy.CacheData<RealmModel>(currentDepth, unmanagedObject));
        } else {
            // Reuse cached object or recreate it because it was encountered at a lower depth.
            if (currentDepth >= cachedObject.minDepth) {
                return (csci81.demo.finalproject.realm.Transaction) cachedObject.object;
            }
            unmanagedObject = (csci81.demo.finalproject.realm.Transaction) cachedObject.object;
            cachedObject.minDepth = currentDepth;
        }
        csci81_demo_finalproject_realm_TransactionRealmProxyInterface unmanagedCopy = (csci81_demo_finalproject_realm_TransactionRealmProxyInterface) unmanagedObject;
        csci81_demo_finalproject_realm_TransactionRealmProxyInterface realmSource = (csci81_demo_finalproject_realm_TransactionRealmProxyInterface) realmObject;
        Realm objectRealm = (Realm) ((RealmObjectProxy) realmObject).realmGet$proxyState().getRealm$realm();
        unmanagedCopy.realmSet$transactionID(realmSource.realmGet$transactionID());
        unmanagedCopy.realmSet$rentalID(realmSource.realmGet$rentalID());
        unmanagedCopy.realmSet$userID(realmSource.realmGet$userID());
        unmanagedCopy.realmSet$amount(realmSource.realmGet$amount());
        unmanagedCopy.realmSet$transactionDate(realmSource.realmGet$transactionDate());

        return unmanagedObject;
    }

    static csci81.demo.finalproject.realm.Transaction update(Realm realm, TransactionColumnInfo columnInfo, csci81.demo.finalproject.realm.Transaction realmObject, csci81.demo.finalproject.realm.Transaction newObject, Map<RealmModel, RealmObjectProxy> cache, Set<ImportFlag> flags) {
        csci81_demo_finalproject_realm_TransactionRealmProxyInterface realmObjectTarget = (csci81_demo_finalproject_realm_TransactionRealmProxyInterface) realmObject;
        csci81_demo_finalproject_realm_TransactionRealmProxyInterface realmObjectSource = (csci81_demo_finalproject_realm_TransactionRealmProxyInterface) newObject;
        Table table = realm.getTable(csci81.demo.finalproject.realm.Transaction.class);
        OsObjectBuilder builder = new OsObjectBuilder(table, flags);
        builder.addString(columnInfo.transactionIDColKey, realmObjectSource.realmGet$transactionID());
        builder.addString(columnInfo.rentalIDColKey, realmObjectSource.realmGet$rentalID());
        builder.addString(columnInfo.userIDColKey, realmObjectSource.realmGet$userID());
        builder.addInteger(columnInfo.amountColKey, realmObjectSource.realmGet$amount());
        builder.addString(columnInfo.transactionDateColKey, realmObjectSource.realmGet$transactionDate());

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
        csci81_demo_finalproject_realm_TransactionRealmProxy aTransaction = (csci81_demo_finalproject_realm_TransactionRealmProxy)o;

        BaseRealm realm = proxyState.getRealm$realm();
        BaseRealm otherRealm = aTransaction.proxyState.getRealm$realm();
        String path = realm.getPath();
        String otherPath = otherRealm.getPath();
        if (path != null ? !path.equals(otherPath) : otherPath != null) return false;
        if (realm.isFrozen() != otherRealm.isFrozen()) return false;
        if (!realm.sharedRealm.getVersionID().equals(otherRealm.sharedRealm.getVersionID())) {
            return false;
        }

        String tableName = proxyState.getRow$realm().getTable().getName();
        String otherTableName = aTransaction.proxyState.getRow$realm().getTable().getName();
        if (tableName != null ? !tableName.equals(otherTableName) : otherTableName != null) return false;

        if (proxyState.getRow$realm().getObjectKey() != aTransaction.proxyState.getRow$realm().getObjectKey()) return false;

        return true;
    }
}
