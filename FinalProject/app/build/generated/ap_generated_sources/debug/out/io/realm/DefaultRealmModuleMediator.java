package io.realm;


import android.util.JsonReader;
import io.realm.ImportFlag;
import io.realm.internal.ColumnInfo;
import io.realm.internal.OsObjectSchemaInfo;
import io.realm.internal.OsSchemaInfo;
import io.realm.internal.RealmObjectProxy;
import io.realm.internal.RealmProxyMediator;
import io.realm.internal.Row;
import java.io.IOException;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;

@io.realm.annotations.RealmModule
class DefaultRealmModuleMediator extends RealmProxyMediator {

    private static final Set<Class<? extends RealmModel>> MODEL_CLASSES;
    static {
        Set<Class<? extends RealmModel>> modelClasses = new HashSet<Class<? extends RealmModel>>(4);
        modelClasses.add(csci81.demo.finalproject.realm.Movie.class);
        modelClasses.add(csci81.demo.finalproject.realm.Rental.class);
        modelClasses.add(csci81.demo.finalproject.realm.Transaction.class);
        modelClasses.add(csci81.demo.finalproject.realm.User.class);
        MODEL_CLASSES = Collections.unmodifiableSet(modelClasses);
    }

    @Override
    public Map<Class<? extends RealmModel>, OsObjectSchemaInfo> getExpectedObjectSchemaInfoMap() {
        Map<Class<? extends RealmModel>, OsObjectSchemaInfo> infoMap = new HashMap<Class<? extends RealmModel>, OsObjectSchemaInfo>(4);
        infoMap.put(csci81.demo.finalproject.realm.Movie.class, io.realm.csci81_demo_finalproject_realm_MovieRealmProxy.getExpectedObjectSchemaInfo());
        infoMap.put(csci81.demo.finalproject.realm.Rental.class, io.realm.csci81_demo_finalproject_realm_RentalRealmProxy.getExpectedObjectSchemaInfo());
        infoMap.put(csci81.demo.finalproject.realm.Transaction.class, io.realm.csci81_demo_finalproject_realm_TransactionRealmProxy.getExpectedObjectSchemaInfo());
        infoMap.put(csci81.demo.finalproject.realm.User.class, io.realm.csci81_demo_finalproject_realm_UserRealmProxy.getExpectedObjectSchemaInfo());
        return infoMap;
    }

    @Override
    public ColumnInfo createColumnInfo(Class<? extends RealmModel> clazz, OsSchemaInfo schemaInfo) {
        checkClass(clazz);

        if (clazz.equals(csci81.demo.finalproject.realm.Movie.class)) {
            return io.realm.csci81_demo_finalproject_realm_MovieRealmProxy.createColumnInfo(schemaInfo);
        }
        if (clazz.equals(csci81.demo.finalproject.realm.Rental.class)) {
            return io.realm.csci81_demo_finalproject_realm_RentalRealmProxy.createColumnInfo(schemaInfo);
        }
        if (clazz.equals(csci81.demo.finalproject.realm.Transaction.class)) {
            return io.realm.csci81_demo_finalproject_realm_TransactionRealmProxy.createColumnInfo(schemaInfo);
        }
        if (clazz.equals(csci81.demo.finalproject.realm.User.class)) {
            return io.realm.csci81_demo_finalproject_realm_UserRealmProxy.createColumnInfo(schemaInfo);
        }
        throw getMissingProxyClassException(clazz);
    }

    @Override
    public String getSimpleClassNameImpl(Class<? extends RealmModel> clazz) {
        checkClass(clazz);

        if (clazz.equals(csci81.demo.finalproject.realm.Movie.class)) {
            return "Movie";
        }
        if (clazz.equals(csci81.demo.finalproject.realm.Rental.class)) {
            return "Rental";
        }
        if (clazz.equals(csci81.demo.finalproject.realm.Transaction.class)) {
            return "Transaction";
        }
        if (clazz.equals(csci81.demo.finalproject.realm.User.class)) {
            return "User";
        }
        throw getMissingProxyClassException(clazz);
    }

    @Override
    public Class<? extends RealmModel> getClazzImpl(String className) {
        checkClassName(className);

        if (className.equals("Movie")) {
            return csci81.demo.finalproject.realm.Movie.class;
        }
        if (className.equals("Rental")) {
            return csci81.demo.finalproject.realm.Rental.class;
        }
        if (className.equals("Transaction")) {
            return csci81.demo.finalproject.realm.Transaction.class;
        }
        if (className.equals("User")) {
            return csci81.demo.finalproject.realm.User.class;
        }
        throw getMissingProxyClassException(className);
    }

    @Override
    public boolean hasPrimaryKeyImpl(Class<? extends RealmModel> clazz) {
        return csci81.demo.finalproject.realm.Movie.class.isAssignableFrom(clazz)
                || csci81.demo.finalproject.realm.Rental.class.isAssignableFrom(clazz)
                || csci81.demo.finalproject.realm.Transaction.class.isAssignableFrom(clazz)
                || csci81.demo.finalproject.realm.User.class.isAssignableFrom(clazz);
    }

    @Override
    public <E extends RealmModel> E newInstance(Class<E> clazz, Object baseRealm, Row row, ColumnInfo columnInfo, boolean acceptDefaultValue, List<String> excludeFields) {
        final BaseRealm.RealmObjectContext objectContext = BaseRealm.objectContext.get();
        try {
            objectContext.set((BaseRealm) baseRealm, row, columnInfo, acceptDefaultValue, excludeFields);
            checkClass(clazz);

            if (clazz.equals(csci81.demo.finalproject.realm.Movie.class)) {
                return clazz.cast(new io.realm.csci81_demo_finalproject_realm_MovieRealmProxy());
            }
            if (clazz.equals(csci81.demo.finalproject.realm.Rental.class)) {
                return clazz.cast(new io.realm.csci81_demo_finalproject_realm_RentalRealmProxy());
            }
            if (clazz.equals(csci81.demo.finalproject.realm.Transaction.class)) {
                return clazz.cast(new io.realm.csci81_demo_finalproject_realm_TransactionRealmProxy());
            }
            if (clazz.equals(csci81.demo.finalproject.realm.User.class)) {
                return clazz.cast(new io.realm.csci81_demo_finalproject_realm_UserRealmProxy());
            }
            throw getMissingProxyClassException(clazz);
        } finally {
            objectContext.clear();
        }
    }

    @Override
    public Set<Class<? extends RealmModel>> getModelClasses() {
        return MODEL_CLASSES;
    }

    @Override
    public <E extends RealmModel> E copyOrUpdate(Realm realm, E obj, boolean update, Map<RealmModel, RealmObjectProxy> cache, Set<ImportFlag> flags) {
        // This cast is correct because obj is either
        // generated by RealmProxy or the original type extending directly from RealmObject
        @SuppressWarnings("unchecked") Class<E> clazz = (Class<E>) ((obj instanceof RealmObjectProxy) ? obj.getClass().getSuperclass() : obj.getClass());

        if (clazz.equals(csci81.demo.finalproject.realm.Movie.class)) {
            csci81_demo_finalproject_realm_MovieRealmProxy.MovieColumnInfo columnInfo = (csci81_demo_finalproject_realm_MovieRealmProxy.MovieColumnInfo) realm.getSchema().getColumnInfo(csci81.demo.finalproject.realm.Movie.class);
            return clazz.cast(io.realm.csci81_demo_finalproject_realm_MovieRealmProxy.copyOrUpdate(realm, columnInfo, (csci81.demo.finalproject.realm.Movie) obj, update, cache, flags));
        }
        if (clazz.equals(csci81.demo.finalproject.realm.Rental.class)) {
            csci81_demo_finalproject_realm_RentalRealmProxy.RentalColumnInfo columnInfo = (csci81_demo_finalproject_realm_RentalRealmProxy.RentalColumnInfo) realm.getSchema().getColumnInfo(csci81.demo.finalproject.realm.Rental.class);
            return clazz.cast(io.realm.csci81_demo_finalproject_realm_RentalRealmProxy.copyOrUpdate(realm, columnInfo, (csci81.demo.finalproject.realm.Rental) obj, update, cache, flags));
        }
        if (clazz.equals(csci81.demo.finalproject.realm.Transaction.class)) {
            csci81_demo_finalproject_realm_TransactionRealmProxy.TransactionColumnInfo columnInfo = (csci81_demo_finalproject_realm_TransactionRealmProxy.TransactionColumnInfo) realm.getSchema().getColumnInfo(csci81.demo.finalproject.realm.Transaction.class);
            return clazz.cast(io.realm.csci81_demo_finalproject_realm_TransactionRealmProxy.copyOrUpdate(realm, columnInfo, (csci81.demo.finalproject.realm.Transaction) obj, update, cache, flags));
        }
        if (clazz.equals(csci81.demo.finalproject.realm.User.class)) {
            csci81_demo_finalproject_realm_UserRealmProxy.UserColumnInfo columnInfo = (csci81_demo_finalproject_realm_UserRealmProxy.UserColumnInfo) realm.getSchema().getColumnInfo(csci81.demo.finalproject.realm.User.class);
            return clazz.cast(io.realm.csci81_demo_finalproject_realm_UserRealmProxy.copyOrUpdate(realm, columnInfo, (csci81.demo.finalproject.realm.User) obj, update, cache, flags));
        }
        throw getMissingProxyClassException(clazz);
    }

    @Override
    public long insert(Realm realm, RealmModel object, Map<RealmModel, Long> cache) {
        // This cast is correct because obj is either
        // generated by RealmProxy or the original type extending directly from RealmObject
        @SuppressWarnings("unchecked") Class<RealmModel> clazz = (Class<RealmModel>) ((object instanceof RealmObjectProxy) ? object.getClass().getSuperclass() : object.getClass());

        if (clazz.equals(csci81.demo.finalproject.realm.Movie.class)) {
            return io.realm.csci81_demo_finalproject_realm_MovieRealmProxy.insert(realm, (csci81.demo.finalproject.realm.Movie) object, cache);
        } else if (clazz.equals(csci81.demo.finalproject.realm.Rental.class)) {
            return io.realm.csci81_demo_finalproject_realm_RentalRealmProxy.insert(realm, (csci81.demo.finalproject.realm.Rental) object, cache);
        } else if (clazz.equals(csci81.demo.finalproject.realm.Transaction.class)) {
            return io.realm.csci81_demo_finalproject_realm_TransactionRealmProxy.insert(realm, (csci81.demo.finalproject.realm.Transaction) object, cache);
        } else if (clazz.equals(csci81.demo.finalproject.realm.User.class)) {
            return io.realm.csci81_demo_finalproject_realm_UserRealmProxy.insert(realm, (csci81.demo.finalproject.realm.User) object, cache);
        } else {
            throw getMissingProxyClassException(clazz);
        }
    }

    @Override
    public void insert(Realm realm, Collection<? extends RealmModel> objects) {
        Iterator<? extends RealmModel> iterator = objects.iterator();
        RealmModel object = null;
        Map<RealmModel, Long> cache = new HashMap<RealmModel, Long>(objects.size());
        if (iterator.hasNext()) {
            //  access the first element to figure out the clazz for the routing below
            object = iterator.next();
            // This cast is correct because obj is either
            // generated by RealmProxy or the original type extending directly from RealmObject
            @SuppressWarnings("unchecked") Class<RealmModel> clazz = (Class<RealmModel>) ((object instanceof RealmObjectProxy) ? object.getClass().getSuperclass() : object.getClass());

            if (clazz.equals(csci81.demo.finalproject.realm.Movie.class)) {
                io.realm.csci81_demo_finalproject_realm_MovieRealmProxy.insert(realm, (csci81.demo.finalproject.realm.Movie) object, cache);
            } else if (clazz.equals(csci81.demo.finalproject.realm.Rental.class)) {
                io.realm.csci81_demo_finalproject_realm_RentalRealmProxy.insert(realm, (csci81.demo.finalproject.realm.Rental) object, cache);
            } else if (clazz.equals(csci81.demo.finalproject.realm.Transaction.class)) {
                io.realm.csci81_demo_finalproject_realm_TransactionRealmProxy.insert(realm, (csci81.demo.finalproject.realm.Transaction) object, cache);
            } else if (clazz.equals(csci81.demo.finalproject.realm.User.class)) {
                io.realm.csci81_demo_finalproject_realm_UserRealmProxy.insert(realm, (csci81.demo.finalproject.realm.User) object, cache);
            } else {
                throw getMissingProxyClassException(clazz);
            }
            if (iterator.hasNext()) {
                if (clazz.equals(csci81.demo.finalproject.realm.Movie.class)) {
                    io.realm.csci81_demo_finalproject_realm_MovieRealmProxy.insert(realm, iterator, cache);
                } else if (clazz.equals(csci81.demo.finalproject.realm.Rental.class)) {
                    io.realm.csci81_demo_finalproject_realm_RentalRealmProxy.insert(realm, iterator, cache);
                } else if (clazz.equals(csci81.demo.finalproject.realm.Transaction.class)) {
                    io.realm.csci81_demo_finalproject_realm_TransactionRealmProxy.insert(realm, iterator, cache);
                } else if (clazz.equals(csci81.demo.finalproject.realm.User.class)) {
                    io.realm.csci81_demo_finalproject_realm_UserRealmProxy.insert(realm, iterator, cache);
                } else {
                    throw getMissingProxyClassException(clazz);
                }
            }
        }
    }

    @Override
    public long insertOrUpdate(Realm realm, RealmModel obj, Map<RealmModel, Long> cache) {
        // This cast is correct because obj is either
        // generated by RealmProxy or the original type extending directly from RealmObject
        @SuppressWarnings("unchecked") Class<RealmModel> clazz = (Class<RealmModel>) ((obj instanceof RealmObjectProxy) ? obj.getClass().getSuperclass() : obj.getClass());

        if (clazz.equals(csci81.demo.finalproject.realm.Movie.class)) {
            return io.realm.csci81_demo_finalproject_realm_MovieRealmProxy.insertOrUpdate(realm, (csci81.demo.finalproject.realm.Movie) obj, cache);
        } else if (clazz.equals(csci81.demo.finalproject.realm.Rental.class)) {
            return io.realm.csci81_demo_finalproject_realm_RentalRealmProxy.insertOrUpdate(realm, (csci81.demo.finalproject.realm.Rental) obj, cache);
        } else if (clazz.equals(csci81.demo.finalproject.realm.Transaction.class)) {
            return io.realm.csci81_demo_finalproject_realm_TransactionRealmProxy.insertOrUpdate(realm, (csci81.demo.finalproject.realm.Transaction) obj, cache);
        } else if (clazz.equals(csci81.demo.finalproject.realm.User.class)) {
            return io.realm.csci81_demo_finalproject_realm_UserRealmProxy.insertOrUpdate(realm, (csci81.demo.finalproject.realm.User) obj, cache);
        } else {
            throw getMissingProxyClassException(clazz);
        }
    }

    @Override
    public void insertOrUpdate(Realm realm, Collection<? extends RealmModel> objects) {
        Iterator<? extends RealmModel> iterator = objects.iterator();
        RealmModel object = null;
        Map<RealmModel, Long> cache = new HashMap<RealmModel, Long>(objects.size());
        if (iterator.hasNext()) {
            //  access the first element to figure out the clazz for the routing below
            object = iterator.next();
            // This cast is correct because obj is either
            // generated by RealmProxy or the original type extending directly from RealmObject
            @SuppressWarnings("unchecked") Class<RealmModel> clazz = (Class<RealmModel>) ((object instanceof RealmObjectProxy) ? object.getClass().getSuperclass() : object.getClass());

            if (clazz.equals(csci81.demo.finalproject.realm.Movie.class)) {
                io.realm.csci81_demo_finalproject_realm_MovieRealmProxy.insertOrUpdate(realm, (csci81.demo.finalproject.realm.Movie) object, cache);
            } else if (clazz.equals(csci81.demo.finalproject.realm.Rental.class)) {
                io.realm.csci81_demo_finalproject_realm_RentalRealmProxy.insertOrUpdate(realm, (csci81.demo.finalproject.realm.Rental) object, cache);
            } else if (clazz.equals(csci81.demo.finalproject.realm.Transaction.class)) {
                io.realm.csci81_demo_finalproject_realm_TransactionRealmProxy.insertOrUpdate(realm, (csci81.demo.finalproject.realm.Transaction) object, cache);
            } else if (clazz.equals(csci81.demo.finalproject.realm.User.class)) {
                io.realm.csci81_demo_finalproject_realm_UserRealmProxy.insertOrUpdate(realm, (csci81.demo.finalproject.realm.User) object, cache);
            } else {
                throw getMissingProxyClassException(clazz);
            }
            if (iterator.hasNext()) {
                if (clazz.equals(csci81.demo.finalproject.realm.Movie.class)) {
                    io.realm.csci81_demo_finalproject_realm_MovieRealmProxy.insertOrUpdate(realm, iterator, cache);
                } else if (clazz.equals(csci81.demo.finalproject.realm.Rental.class)) {
                    io.realm.csci81_demo_finalproject_realm_RentalRealmProxy.insertOrUpdate(realm, iterator, cache);
                } else if (clazz.equals(csci81.demo.finalproject.realm.Transaction.class)) {
                    io.realm.csci81_demo_finalproject_realm_TransactionRealmProxy.insertOrUpdate(realm, iterator, cache);
                } else if (clazz.equals(csci81.demo.finalproject.realm.User.class)) {
                    io.realm.csci81_demo_finalproject_realm_UserRealmProxy.insertOrUpdate(realm, iterator, cache);
                } else {
                    throw getMissingProxyClassException(clazz);
                }
            }
        }
    }

    @Override
    public <E extends RealmModel> E createOrUpdateUsingJsonObject(Class<E> clazz, Realm realm, JSONObject json, boolean update)
        throws JSONException {
        checkClass(clazz);

        if (clazz.equals(csci81.demo.finalproject.realm.Movie.class)) {
            return clazz.cast(io.realm.csci81_demo_finalproject_realm_MovieRealmProxy.createOrUpdateUsingJsonObject(realm, json, update));
        }
        if (clazz.equals(csci81.demo.finalproject.realm.Rental.class)) {
            return clazz.cast(io.realm.csci81_demo_finalproject_realm_RentalRealmProxy.createOrUpdateUsingJsonObject(realm, json, update));
        }
        if (clazz.equals(csci81.demo.finalproject.realm.Transaction.class)) {
            return clazz.cast(io.realm.csci81_demo_finalproject_realm_TransactionRealmProxy.createOrUpdateUsingJsonObject(realm, json, update));
        }
        if (clazz.equals(csci81.demo.finalproject.realm.User.class)) {
            return clazz.cast(io.realm.csci81_demo_finalproject_realm_UserRealmProxy.createOrUpdateUsingJsonObject(realm, json, update));
        }
        throw getMissingProxyClassException(clazz);
    }

    @Override
    public <E extends RealmModel> E createUsingJsonStream(Class<E> clazz, Realm realm, JsonReader reader)
        throws IOException {
        checkClass(clazz);

        if (clazz.equals(csci81.demo.finalproject.realm.Movie.class)) {
            return clazz.cast(io.realm.csci81_demo_finalproject_realm_MovieRealmProxy.createUsingJsonStream(realm, reader));
        }
        if (clazz.equals(csci81.demo.finalproject.realm.Rental.class)) {
            return clazz.cast(io.realm.csci81_demo_finalproject_realm_RentalRealmProxy.createUsingJsonStream(realm, reader));
        }
        if (clazz.equals(csci81.demo.finalproject.realm.Transaction.class)) {
            return clazz.cast(io.realm.csci81_demo_finalproject_realm_TransactionRealmProxy.createUsingJsonStream(realm, reader));
        }
        if (clazz.equals(csci81.demo.finalproject.realm.User.class)) {
            return clazz.cast(io.realm.csci81_demo_finalproject_realm_UserRealmProxy.createUsingJsonStream(realm, reader));
        }
        throw getMissingProxyClassException(clazz);
    }

    @Override
    public <E extends RealmModel> E createDetachedCopy(E realmObject, int maxDepth, Map<RealmModel, RealmObjectProxy.CacheData<RealmModel>> cache) {
        // This cast is correct because obj is either
        // generated by RealmProxy or the original type extending directly from RealmObject
        @SuppressWarnings("unchecked") Class<E> clazz = (Class<E>) realmObject.getClass().getSuperclass();

        if (clazz.equals(csci81.demo.finalproject.realm.Movie.class)) {
            return clazz.cast(io.realm.csci81_demo_finalproject_realm_MovieRealmProxy.createDetachedCopy((csci81.demo.finalproject.realm.Movie) realmObject, 0, maxDepth, cache));
        }
        if (clazz.equals(csci81.demo.finalproject.realm.Rental.class)) {
            return clazz.cast(io.realm.csci81_demo_finalproject_realm_RentalRealmProxy.createDetachedCopy((csci81.demo.finalproject.realm.Rental) realmObject, 0, maxDepth, cache));
        }
        if (clazz.equals(csci81.demo.finalproject.realm.Transaction.class)) {
            return clazz.cast(io.realm.csci81_demo_finalproject_realm_TransactionRealmProxy.createDetachedCopy((csci81.demo.finalproject.realm.Transaction) realmObject, 0, maxDepth, cache));
        }
        if (clazz.equals(csci81.demo.finalproject.realm.User.class)) {
            return clazz.cast(io.realm.csci81_demo_finalproject_realm_UserRealmProxy.createDetachedCopy((csci81.demo.finalproject.realm.User) realmObject, 0, maxDepth, cache));
        }
        throw getMissingProxyClassException(clazz);
    }

    @Override
    public <E extends RealmModel> boolean isEmbedded(Class<E> clazz) {
        if (clazz.equals(csci81.demo.finalproject.realm.Movie.class)) {
            return false;
        }
        if (clazz.equals(csci81.demo.finalproject.realm.Rental.class)) {
            return false;
        }
        if (clazz.equals(csci81.demo.finalproject.realm.Transaction.class)) {
            return false;
        }
        if (clazz.equals(csci81.demo.finalproject.realm.User.class)) {
            return false;
        }
        throw getMissingProxyClassException(clazz);
    }

    @Override
    public <E extends RealmModel> void updateEmbeddedObject(Realm realm, E unmanagedObject, E managedObject, Map<RealmModel, RealmObjectProxy> cache, Set<ImportFlag> flags) {
        // This cast is correct because obj is either
        // generated by RealmProxy or the original type extending directly from RealmObject
        @SuppressWarnings("unchecked") Class<E> clazz = (Class<E>) managedObject.getClass().getSuperclass();

        if (clazz.equals(csci81.demo.finalproject.realm.Movie.class)) {
            throw getNotEmbeddedClassException("csci81.demo.finalproject.realm.Movie");
        } else if (clazz.equals(csci81.demo.finalproject.realm.Rental.class)) {
            throw getNotEmbeddedClassException("csci81.demo.finalproject.realm.Rental");
        } else if (clazz.equals(csci81.demo.finalproject.realm.Transaction.class)) {
            throw getNotEmbeddedClassException("csci81.demo.finalproject.realm.Transaction");
        } else if (clazz.equals(csci81.demo.finalproject.realm.User.class)) {
            throw getNotEmbeddedClassException("csci81.demo.finalproject.realm.User");
        } else {
            throw getMissingProxyClassException(clazz);
        }
    }

}
