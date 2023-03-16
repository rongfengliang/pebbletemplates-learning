package com.dalong;

import io.minio.GetObjectArgs;
import io.minio.GetObjectResponse;
import io.minio.MinioClient;
import io.minio.errors.*;
import io.pebbletemplates.pebble.loader.Loader;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

public class S3Loader implements Loader<String> {

    private MinioClient minioClient;
    private String bucket;
    public S3Loader(MinioClient minioClient,String bucket) {
        this.minioClient = minioClient;
        this.bucket=bucket;
    }

    @Override
    public Reader getReader(String cacheKey) {
        Reader targetReader = null;
        try {
            GetObjectResponse response = this.minioClient.getObject(GetObjectArgs.builder().bucket(this.bucket).object(cacheKey).build());
            targetReader = new InputStreamReader(response);
        } catch (ErrorResponseException e) {
            throw new RuntimeException(e);
        } catch (InsufficientDataException e) {
            throw new RuntimeException(e);
        } catch (InternalException e) {
            throw new RuntimeException(e);
        } catch (InvalidKeyException e) {
            throw new RuntimeException(e);
        } catch (InvalidResponseException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        } catch (ServerException e) {
            throw new RuntimeException(e);
        } catch (XmlParserException e) {
            throw new RuntimeException(e);
        }
        return targetReader;
    }

    @Override
    public void setCharset(String charset) {

    }

    @Override
    public void setPrefix(String prefix) {

    }

    @Override
    public void setSuffix(String suffix) {

    }

    @Override
    public String resolveRelativePath(String relativePath, String anchorPath) {
        return null;
    }

    @Override
    public String createCacheKey(String templateName) {
        return templateName;
    }

    @Override
    public boolean resourceExists(String templateName) {
        return true;
    }
}
