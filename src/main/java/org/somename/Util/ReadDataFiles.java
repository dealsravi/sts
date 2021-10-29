package org.somename.Util;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Collection;
import java.util.StringTokenizer;

import org.apache.commons.lang3.StringUtils;
import org.somename.constants.F2I_C;

public class ReadDataFiles {

    /**
     *  For Now Assume that ALL the fields are available in the data file in EACH line for loading.
     *  This is Just a Helper to MOCK the data, written as a stop gap util.
     * @param objectClass
     * @param returnCollection
     * @param inputFile
     * @param methodList
     * @param delimiter
     * @param <T>
     */
    public static <T> void loadObjectsFromFile(Class<T> objectClass, Collection<T> returnCollection, String inputFile, String[] methodList, String delimiter) {

        BufferedReader br = null;
        try {

            if(StringUtils.isEmpty(inputFile) ||
                    methodList==null || methodList.length==0 || StringUtils.isAnyEmpty(methodList) ||
                    StringUtils.isEmpty(delimiter) ) {
                returnCollection = null;
                return;
            }

            //returnCollection = new ArrayList<T>();
            Method[] objectMethods = getMethodsForObject(objectClass, methodList);

            br = new BufferedReader(new FileReader(inputFile));
            String line;
            while((line=br.readLine()) != null) {
                //For Now Assume that ALL the fields are available in the data file in EACH line for loading.
                StringTokenizer tknzr = new StringTokenizer(line,delimiter);
                String token;
                Object object = objectClass.newInstance();
                for(Method method : objectMethods) {
                    token = tknzr.nextToken();
                    method.invoke(object,token);

                }
                returnCollection.add((T) object);

            }

        } catch (InstantiationException | IllegalAccessException | IOException | InvocationTargetException e) {
            // For now Catch in one block
            e.printStackTrace();
            returnCollection = null;
        } finally {
            if(br!=null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                    returnCollection = null;
                }
            }
        }

    }

    private static <T> Method[] getMethodsForObject(Class<T> objectClass, String[] methodNames) {

        Method[] methods = objectClass.getMethods();
        Method[] orderedMethods = new Method[methodNames.length];
        for(int i=0; i<methodNames.length; i++) {
            for(Method method: methods)
                if(method.getName().toLowerCase().contains(methodNames[i].toLowerCase())) {
                    orderedMethods[i] = method;
                }
        }
        return orderedMethods;
    }


}
