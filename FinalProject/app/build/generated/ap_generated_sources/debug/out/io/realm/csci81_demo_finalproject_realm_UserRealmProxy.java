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
public class csci81_demo_finalproject_realm_UserRealmProxy extends csci81.demo.finalproject.realm.User
    implements RealmObjectProxy, csci81_demo_finalproject_realm_UserRealmProxyInterface {

    static final class UserColumnInfo extends ColumnInfo {
        long userIDColKey;
        long nameColKey;
        long passwordColKey;
        long emailAddressColKey;
        long addressColKey;

        UserColumnInfo(OsSchemaInfo schemaInfo) {
            super(5);
            OsObjectSchemaInfo objectSchemaInfo = schemaInfo.getObjectSchemaInfo("User");
            this.userIDColKey = addColumnDetails("userID", "userID", objectSchemaInfo);
            this.nameColKey = addColumnDetails("name", "name", objectSchemaInfo);
            this.passwordColKey = addColumnDetails("password", "password", objectSchemaInfo);
            this.emailAddressColKey = addColumnDetails("emailAddress", "emailAddress", objectSchemaInfo);
            this.addressColKey = addColumnDetails("address", "address", objectSchemaInfo);
        }

        UserColumnInfo(ColumnInfo src, boolean mutable) {
            super(src, mutable);
            copy(src, this);
        }

        @Override
        protected final ColumnInfo copy(boolean mutable) {
            return new UserColumnInfo(this, mutable);
        }

        @Override
        protected final void copy(ColumnInfo rawSrc, ColumnInfo rawDst) {
            final UserColumnInfo src = (UserColumnInfo) rawSrc;
            final UserColumnInfo dst = (UserColumnInfo) rawDst;
            dst.userIDColKey = src.userIDColKey;
            dst.nameColKey = src.nameColKey;
            dst.passwordColKey = src.passwordColKey;
            dst.emailAddressColKey = src.emailAddressColKey;
            dst.addressColKey = src.addressColKey;
        }
    }

    private static final String NO_ALIAS = "";
    private static final OsObjectSchemaInfo expectedObjectSchemaInfo = createExpectedObjectSchemaInfo();

    private UserColumnInfo columnInfo;
    private ProxyState<csci81.demo.finalproject.realm.User> proxyState;

    csci81_demo_finalproject_realm_UserRealmProxy() {
        proxyState.setConstructionFinished();
    }

    @Override
    public void realm$injectObjectContext() {
        if (this.proxyState != null) {
            return;
        }
        final BaseRealm.RealmObjectContext context = BaseRealm.objectContext.get();
        this.columnInfo = (UserColumnInfo) context.getColumnInfo();
        this.proxyState = new ProxyState<csci81.demo.finalproject.realm.User>(this);
        proxyState.setRealm$realm(context.getRealm());
        proxyState.setRow$realm(context.getRow());
        proxyState.setAcceptDefaultValue$realm(context.getAcceptDefaultValue());
        proxyState.setExcludeFields$realm(context.getExcludeFields());
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
            // default value of the primary key is always ignored.
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        throw new io.realm.exceptions.RealmException("Primary key field 'userID' cannot be changed after object was created.");
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$name() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.nameColKey);
    }

    @Override
    public void realmSet$name(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.nameColKey, row.getObjectKey(), true);
                return;
            }
            row.getTable().setString(columnInfo.nameColKey, row.getObjectKey(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.nameColKey);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.nameColKey, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$password() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.passwordColKey);
    }

    @Override
    public void realmSet$password(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.passwordColKey, row.getObjectKey(), true);
                return;
            }
            row.getTable().setString(columnInfo.passwordColKey, row.getObjectKey(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.passwordColKey);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.passwordColKey, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$emailAddress() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.emailAddressColKey);
    }

    @Override
    public void realmSet$emailAddress(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.emailAddressColKey, row.getObjectKey(), true);
                return;
            }
            row.getTable().setString(columnInfo.emailAddressColKey, row.getObjectKey(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.emailAddressColKey);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.emailAddressColKey, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$address() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.addressColKey);
    }

    @Override
    public void realmSet$address(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.addressColKey, row.getObjectKey(), true);
                return;
            }
            row.getTable().setString(columnInfo.addressColKey, row.getObjectKey(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.addressColKey);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.addressColKey, value);
    }

    private static OsObjectSchemaInfo createExpectedObjectSchemaInfo() {
        OsObjectSchemaInfo.Builder builder = new OsObjectSchemaInfo.Builder(NO_ALIAS, "User", false, 5, 0);
        builder.addPersistedProperty(NO_ALIAS, "userID", RealmFieldType.STRING, Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty(NO_ALIAS, "name", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty(NO_ALIAS, "password", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty(NO_ALIAS, "emailAddress", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty(NO_ALIAS, "address", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        return builder.build();
    }

    public static OsObjectSchemaInfo getExpectedObjectSchemaInfo() {
        return expectedObjectSchemaInfo;
    }

    public static UserColumnInfo createColumnInfo(OsSchemaInfo schemaInfo) {
        return new UserColumnInfo(schemaInfo);
    }

    public static String getSimpleClassName() {
        return "User";
    }

    public static final class ClassNameHelper {
        public static final String INTERNAL_CLASS_NAME = "User";
    }

    @SuppressWarnings("cast")
    public static csci81.demo.finalproject.realm.User createOrUpdateUsingJsonObject(Realm realm, JSONObject json, boolean update)
        throws JSONException {
        final List<String> excludeFields = Collections.<String> emptyList();
        csci81.demo.finalproject.realm.User obj = null;
        if (update) {
            Table table = realm.getTable(csci81.demo.finalproject.realm.User.class);
            UserColumnInfo columnInfo = (UserColumnInfo) realm.getSchema().getColumnInfo(csci81.demo.finalproject.realm.User.class);
            long pkColumnKey = columnInfo.userIDColKey;
            long objKey = Table.NO_MATCH;
            if (json.isNull("userID")) {
                objKey = table.findFirstNull(pkColumnKey);
            } else {
                objKey = table.findFirstString(pkColumnKey, json.getString("userID"));
            }
            if (objKey != Table.NO_MATCH) {
                final BaseRealm.RealmObjectContext objectContext = BaseRealm.objectContext.get();
                try {
                    objectContext.set(realm, table.getUncheckedRow(objKey), realm.getSchema().getColumnInfo(csci81.demo.finalproject.realm.User.class), false, Collections.<String> emptyList());
                    obj = new io.realm.csci81_demo_finalproject_realm_UserRealmProxy();
                } finally {
                    objectContext.clear();
                }
            }
        }
        if (obj == null) {
            if (json.has("userID")) {
                if (json.isNull("userID")) {
                    obj = (io.realm.csci81_demo_finalproject_realm_UserRealmProxy) realm.createObjectInternal(csci81.demo.finalproject.realm.User.class, null, true, excludeFields);
                } else {
                    obj = (io.realm.csci81_demo_finalproject_realm_UserRealmProxy) realm.createObjectInternal(csci81.demo.finalproject.realm.User.class, json.getString("userID"), true, excludeFields);
                }
            } else {
                throw new IllegalArgumentException("JSON object doesn't have the primary key field 'userID'.");
            }
        }

        final csci81_demo_finalproject_realm_UserRealmProxyInterface objProxy = (csci81_demo_finalproject_realm_UserRealmProxyInterface) obj;
        if (json.has("name")) {
            if (json.isNull("name")) {
                objProxy.realmSet$name(null);
            } else {
                objProxy.realmSet$name((String) json.getString("name"));
            }
        }
        if (json.has("password")) {
            if (json.isNull("password")) {
                objProxy.realmSet$password(null);
            } else {
                objProxy.realmSet$password((String) json.getString("password"));
            }
        }
        if (json.has("emailAddress")) {
            if (json.isNull("emailAddress")) {
                objProxy.realmSet$emailAddress(null);
            } else {
                objProxy.realmSet$emailAddress((String) json.getString("emailAddress"));
            }
        }
        if (json.has("address")) {
            if (json.isNull("address")) {
                objProxy.realmSet$address(null);
            } else {
                objProxy.realmSet$address((String) json.getString("address"));
            }
        }
        return obj;
    }

    @SuppressWarnings("cast")
    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    public static csci81.demo.finalproject.realm.User createUsingJsonStream(Realm realm, JsonReader reader)
        throws IOException {
        boolean jsonHasPrimaryKey = false;
        final csci81.demo.finalproject.realm.User obj = new csci81.demo.finalproject.realm.User();
        final csci81_demo_finalproject_realm_UserRealmProxyInterface objProxy = (csci81_demo_finalproject_realm_UserRealmProxyInterface) obj;
        reader.beginObject();
        while (reader.hasNext()) {
            String name = reader.nextName();
            if (false) {
            } else if (name.equals("userID")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$userID((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$userID(null);
                }
                jsonHasPrimaryKey = true;
            } else if (name.equals("name")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$name((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$name(null);
                }
            } else if (name.equals("password")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$password((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$password(null);
                }
            } else if (name.equals("emailAddress")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$emailAddress((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$emailAddress(null);
                }
            } else if (name.equals("address")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$address((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$address(null);
                }
            } else {
                reader.skipValue();
            }
        }
        reader.endObject();
        if (!jsonHasPrimaryKey) {
            throw new IllegalArgumentException("JSON object doesn't have the primary key field 'userID'.");
        }
        return realm.copyToRealmOrUpdate(obj);
    }

    static csci81_demo_finalproject_realm_UserRealmProxy newProxyInstance(BaseRealm realm, Row row) {
        // Ignore default values to avoid creating unexpected objects from RealmModel/RealmList fields
        final BaseRealm.RealmObjectContext objectContext = BaseRealm.objectContext.get();
        objectContext.set(realm, row, realm.getSchema().getColumnInfo(csci81.demo.finalproject.realm.User.class), false, Collections.<String>emptyList());
        io.realm.csci81_demo_finalproject_realm_UserRealmProxy obj = new io.realm.csci81_demo_finalproject_realm_UserRealmProxy();
        objectContext.clear();
        return obj;
    }

    public static csci81.demo.finalproject.realm.User copyOrUpdate(Realm realm, UserColumnInfo columnInfo, csci81.demo.finalproject.realm.User object, boolean update, Map<RealmModel,RealmObjectProxy> cache, Set<ImportFlag> flags) {
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
            return (csci81.demo.finalproject.realm.User) cachedRealmObject;
        }

        csci81.demo.finalproject.realm.User realmObject = null;
        boolean canUpdate = update;
        if (canUpdate) {
            Table table = realm.getTable(csci81.demo.finalproject.realm.User.class);
            long pkColumnKey = columnInfo.userIDColKey;
            String value = ((csci81_demo_finalproject_realm_UserRealmProxyInterface) object).realmGet$userID();
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
                    realmObject = new io.realm.csci81_demo_finalproject_realm_UserRealmProxy();
                    cache.put(object, (RealmObjectProxy) realmObject);
                } finally {
                    objectContext.clear();
                }
            }
        }

        return (canUpdate) ? update(realm, columnInfo, realmObject, object, cache, flags) : copy(realm, columnInfo, object, update, cache, flags);
    }

    public static csci81.demo.finalproject.realm.User copy(Realm realm, UserColumnInfo columnInfo, csci81.demo.finalproject.realm.User newObject, boolean update, Map<RealmModel,RealmObjectProxy> cache, Set<ImportFlag> flags) {
        RealmObjectProxy cachedRealmObject = cache.get(newObject);
        if (cachedRealmObject != null) {
            return (csci81.demo.finalproject.realm.User) cachedRealmObject;
        }

        csci81_demo_finalproject_realm_UserRealmProxyInterface unmanagedSource = (csci81_demo_finalproject_realm_UserRealmProxyInterface) newObject;

        Table table = realm.getTable(csci81.demo.finalproject.realm.User.class);
        OsObjectBuilder builder = new OsObjectBuilder(table, flags);

        // Add all non-"object reference" fields
        builder.addString(columnInfo.userIDColKey, unmanagedSource.realmGet$userID());
        builder.addString(columnInfo.nameColKey, unmanagedSource.realmGet$name());
        builder.addString(columnInfo.passwordColKey, unmanagedSource.realmGet$password());
        builder.addString(columnInfo.emailAddressColKey, unmanagedSource.realmGet$emailAddress());
        builder.addString(columnInfo.addressColKey, unmanagedSource.realmGet$address());

        // Create the underlying object and cache it before setting any object/objectlist references
        // This will allow us to break any circular dependencies by using the object cache.
        Row row = builder.createNewObject();
        io.realm.csci81_demo_finalproject_realm_UserRealmProxy managedCopy = newProxyInstance(realm, row);
        cache.put(newObject, managedCopy);

        return managedCopy;
    }

    public static long insert(Realm realm, csci81.demo.finalproject.realm.User object, Map<RealmModel,Long> cache) {
        if (object instanceof RealmObjectProxy && !RealmObject.isFrozen(object) && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getObjectKey();
        }
        Table table = realm.getTable(csci81.demo.finalproject.realm.User.class);
        long tableNativePtr = table.getNativePtr();
        UserColumnInfo columnInfo = (UserColumnInfo) realm.getSchema().getColumnInfo(csci81.demo.finalproject.realm.User.class);
        long pkColumnKey = columnInfo.userIDColKey;
        String primaryKeyValue = ((csci81_demo_finalproject_realm_UserRealmProxyInterface) object).realmGet$userID();
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
        String realmGet$name = ((csci81_demo_finalproject_realm_UserRealmProxyInterface) object).realmGet$name();
        if (realmGet$name != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.nameColKey, objKey, realmGet$name, false);
        }
        String realmGet$password = ((csci81_demo_finalproject_realm_UserRealmProxyInterface) object).realmGet$password();
        if (realmGet$password != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.passwordColKey, objKey, realmGet$password, false);
        }
        String realmGet$emailAddress = ((csci81_demo_finalproject_realm_UserRealmProxyInterface) object).realmGet$emailAddress();
        if (realmGet$emailAddress != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.emailAddressColKey, objKey, realmGet$emailAddress, false);
        }
        String realmGet$address = ((csci81_demo_finalproject_realm_UserRealmProxyInterface) object).realmGet$address();
        if (realmGet$address != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.addressColKey, objKey, realmGet$address, false);
        }
        return objKey;
    }

    public static void insert(Realm realm, Iterator<? extends RealmModel> objects, Map<RealmModel,Long> cache) {
        Table table = realm.getTable(csci81.demo.finalproject.realm.User.class);
        long tableNativePtr = table.getNativePtr();
        UserColumnInfo columnInfo = (UserColumnInfo) realm.getSchema().getColumnInfo(csci81.demo.finalproject.realm.User.class);
        long pkColumnKey = columnInfo.userIDColKey;
        csci81.demo.finalproject.realm.User object = null;
        while (objects.hasNext()) {
            object = (csci81.demo.finalproject.realm.User) objects.next();
            if (cache.containsKey(object)) {
                continue;
            }
            if (object instanceof RealmObjectProxy && !RealmObject.isFrozen(object) && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                cache.put(object, ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getObjectKey());
                continue;
            }
            String primaryKeyValue = ((csci81_demo_finalproject_realm_UserRealmProxyInterface) object).realmGet$userID();
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
            String realmGet$name = ((csci81_demo_finalproject_realm_UserRealmProxyInterface) object).realmGet$name();
            if (realmGet$name != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.nameColKey, objKey, realmGet$name, false);
            }
            String realmGet$password = ((csci81_demo_finalproject_realm_UserRealmProxyInterface) object).realmGet$password();
            if (realmGet$password != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.passwordColKey, objKey, realmGet$password, false);
            }
            String realmGet$emailAddress = ((csci81_demo_finalproject_realm_UserRealmProxyInterface) object).realmGet$emailAddress();
            if (realmGet$emailAddress != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.emailAddressColKey, objKey, realmGet$emailAddress, false);
            }
            String realmGet$address = ((csci81_demo_finalproject_realm_UserRealmProxyInterface) object).realmGet$address();
            if (realmGet$address != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.addressColKey, objKey, realmGet$address, false);
            }
        }
    }

    public static long insertOrUpdate(Realm realm, csci81.demo.finalproject.realm.User object, Map<RealmModel,Long> cache) {
        if (object instanceof RealmObjectProxy && !RealmObject.isFrozen(object) && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getObjectKey();
        }
        Table table = realm.getTable(csci81.demo.finalproject.realm.User.class);
        long tableNativePtr = table.getNativePtr();
        UserColumnInfo columnInfo = (UserColumnInfo) realm.getSchema().getColumnInfo(csci81.demo.finalproject.realm.User.class);
        long pkColumnKey = columnInfo.userIDColKey;
        String primaryKeyValue = ((csci81_demo_finalproject_realm_UserRealmProxyInterface) object).realmGet$userID();
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
        String realmGet$name = ((csci81_demo_finalproject_realm_UserRealmProxyInterface) object).realmGet$name();
        if (realmGet$name != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.nameColKey, objKey, realmGet$name, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.nameColKey, objKey, false);
        }
        String realmGet$password = ((csci81_demo_finalproject_realm_UserRealmProxyInterface) object).realmGet$password();
        if (realmGet$password != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.passwordColKey, objKey, realmGet$password, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.passwordColKey, objKey, false);
        }
        String realmGet$emailAddress = ((csci81_demo_finalproject_realm_UserRealmProxyInterface) object).realmGet$emailAddress();
        if (realmGet$emailAddress != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.emailAddressColKey, objKey, realmGet$emailAddress, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.emailAddressColKey, objKey, false);
        }
        String realmGet$address = ((csci81_demo_finalproject_realm_UserRealmProxyInterface) object).realmGet$address();
        if (realmGet$address != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.addressColKey, objKey, realmGet$address, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.addressColKey, objKey, false);
        }
        return objKey;
    }

    public static void insertOrUpdate(Realm realm, Iterator<? extends RealmModel> objects, Map<RealmModel,Long> cache) {
        Table table = realm.getTable(csci81.demo.finalproject.realm.User.class);
        long tableNativePtr = table.getNativePtr();
        UserColumnInfo columnInfo = (UserColumnInfo) realm.getSchema().getColumnInfo(csci81.demo.finalproject.realm.User.class);
        long pkColumnKey = columnInfo.userIDColKey;
        csci81.demo.finalproject.realm.User object = null;
        while (objects.hasNext()) {
            object = (csci81.demo.finalproject.realm.User) objects.next();
            if (cache.containsKey(object)) {
                continue;
            }
            if (object instanceof RealmObjectProxy && !RealmObject.isFrozen(object) && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                cache.put(object, ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getObjectKey());
                continue;
            }
            String primaryKeyValue = ((csci81_demo_finalproject_realm_UserRealmProxyInterface) object).realmGet$userID();
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
            String realmGet$name = ((csci81_demo_finalproject_realm_UserRealmProxyInterface) object).realmGet$name();
            if (realmGet$name != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.nameColKey, objKey, realmGet$name, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.nameColKey, objKey, false);
            }
            String realmGet$password = ((csci81_demo_finalproject_realm_UserRealmProxyInterface) object).realmGet$password();
            if (realmGet$password != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.passwordColKey, objKey, realmGet$password, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.passwordColKey, objKey, false);
            }
            String realmGet$emailAddress = ((csci81_demo_finalproject_realm_UserRealmProxyInterface) object).realmGet$emailAddress();
            if (realmGet$emailAddress != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.emailAddressColKey, objKey, realmGet$emailAddress, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.emailAddressColKey, objKey, false);
            }
            String realmGet$address = ((csci81_demo_finalproject_realm_UserRealmProxyInterface) object).realmGet$address();
            if (realmGet$address != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.addressColKey, objKey, realmGet$address, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.addressColKey, objKey, false);
            }
        }
    }

    public static csci81.demo.finalproject.realm.User createDetachedCopy(csci81.demo.finalproject.realm.User realmObject, int currentDepth, int maxDepth, Map<RealmModel, CacheData<RealmModel>> cache) {
        if (currentDepth > maxDepth || realmObject == null) {
            return null;
        }
        CacheData<RealmModel> cachedObject = cache.get(realmObject);
        csci81.demo.finalproject.realm.User unmanagedObject;
        if (cachedObject == null) {
            unmanagedObject = new csci81.demo.finalproject.realm.User();
            cache.put(realmObject, new RealmObjectProxy.CacheData<RealmModel>(currentDepth, unmanagedObject));
        } else {
            // Reuse cached object or recreate it because it was encountered at a lower depth.
            if (currentDepth >= cachedObject.minDepth) {
                return (csci81.demo.finalproject.realm.User) cachedObject.object;
            }
            unmanagedObject = (csci81.demo.finalproject.realm.User) cachedObject.object;
            cachedObject.minDepth = currentDepth;
        }
        csci81_demo_finalproject_realm_UserRealmProxyInterface unmanagedCopy = (csci81_demo_finalproject_realm_UserRealmProxyInterface) unmanagedObject;
        csci81_demo_finalproject_realm_UserRealmProxyInterface realmSource = (csci81_demo_finalproject_realm_UserRealmProxyInterface) realmObject;
        Realm objectRealm = (Realm) ((RealmObjectProxy) realmObject).realmGet$proxyState().getRealm$realm();
        unmanagedCopy.realmSet$userID(realmSource.realmGet$userID());
        unmanagedCopy.realmSet$name(realmSource.realmGet$name());
        unmanagedCopy.realmSet$password(realmSource.realmGet$password());
        unmanagedCopy.realmSet$emailAddress(realmSource.realmGet$emailAddress());
        unmanagedCopy.realmSet$address(realmSource.realmGet$address());

        return unmanagedObject;
    }

    static csci81.demo.finalproject.realm.User update(Realm realm, UserColumnInfo columnInfo, csci81.demo.finalproject.realm.User realmObject, csci81.demo.finalproject.realm.User newObject, Map<RealmModel, RealmObjectProxy> cache, Set<ImportFlag> flags) {
        csci81_demo_finalproject_realm_UserRealmProxyInterface realmObjectTarget = (csci81_demo_finalproject_realm_UserRealmProxyInterface) realmObject;
        csci81_demo_finalproject_realm_UserRealmProxyInterface realmObjectSource = (csci81_demo_finalproject_realm_UserRealmProxyInterface) newObject;
        Table table = realm.getTable(csci81.demo.finalproject.realm.User.class);
        OsObjectBuilder builder = new OsObjectBuilder(table, flags);
        builder.addString(columnInfo.userIDColKey, realmObjectSource.realmGet$userID());
        builder.addString(columnInfo.nameColKey, realmObjectSource.realmGet$name());
        builder.addString(columnInfo.passwordColKey, realmObjectSource.realmGet$password());
        builder.addString(columnInfo.emailAddressColKey, realmObjectSource.realmGet$emailAddress());
        builder.addString(columnInfo.addressColKey, realmObjectSource.realmGet$address());

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
        csci81_demo_finalproject_realm_UserRealmProxy aUser = (csci81_demo_finalproject_realm_UserRealmProxy)o;

        BaseRealm realm = proxyState.getRealm$realm();
        BaseRealm otherRealm = aUser.proxyState.getRealm$realm();
        String path = realm.getPath();
        String otherPath = otherRealm.getPath();
        if (path != null ? !path.equals(otherPath) : otherPath != null) return false;
        if (realm.isFrozen() != otherRealm.isFrozen()) return false;
        if (!realm.sharedRealm.getVersionID().equals(otherRealm.sharedRealm.getVersionID())) {
            return false;
        }

        String tableName = proxyState.getRow$realm().getTable().getName();
        String otherTableName = aUser.proxyState.getRow$realm().getTable().getName();
        if (tableName != null ? !tableName.equals(otherTableName) : otherTableName != null) return false;

        if (proxyState.getRow$realm().getObjectKey() != aUser.proxyState.getRow$realm().getObjectKey()) return false;

        return true;
    }
}
