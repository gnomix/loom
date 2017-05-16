package io.datawire.loom.fabric

import java.time.Instant


data class FabricSpec(
    val clusterCidr       : String,
    val clusterDomain     : String,
    val clusterDomainZone : String,
    val creationTime      : java.time.Instant?,
    val model             : String,
    val masterNodes       : NodeGroup,
    val name              : String,
    val resourcesNetwork  : ResourcesNetwork,
    val workerNodes       : List<NodeGroup>
)

fun assembleFabricSpec(model: FabricModel, config: FabricConfig) = FabricSpec(
    clusterCidr = config.clusterCidr,
    clusterDomain = "${config.name}.${model.domain}",
    clusterDomainZone = model.domain,
    creationTime = Instant.now(),
    model = model.name,
    masterNodes = model.masterNodes,
    name = config.name,
    resourcesNetwork = model.resourcesNetwork,
    workerNodes = model.workerNodes
)