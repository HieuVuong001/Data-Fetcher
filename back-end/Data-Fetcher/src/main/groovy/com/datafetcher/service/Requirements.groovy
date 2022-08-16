package com.datafetcher.service

import groovy.json.JsonOutput

/**
Every requirements classes must extend this abstract class.

Controller will usee storageProperties and fileTypeProperties to make dynamic form happen on the front-end.
*/
abstract class Requirements {
    def generalReqs = [:]

    abstract Map fileTypeProperties()
    
    abstract Map storageProperties()

    def getRequirements() {
        JsonOutput writer = new JsonOutput();
        def result = generalReqs + this.fileTypeProperties() + this.storageProperties();

        return writer.toJson(result);
    }

    def getStorage() {
        return this.storageProperties();
    }

    def getFileRequirementsJson() {
        JsonOutput writer = new JsonOutput();

        return writer.toJson(this.fileTypeProperties());
    }
}