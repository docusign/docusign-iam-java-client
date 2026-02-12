# BulkJobEmbedded

Contains detailed information about the BulkJob including presigned upload links, document IDs, etc


## Fields

| Field                                                                          | Type                                                                           | Required                                                                       | Description                                                                    | Example                                                                        |
| ------------------------------------------------------------------------------ | ------------------------------------------------------------------------------ | ------------------------------------------------------------------------------ | ------------------------------------------------------------------------------ | ------------------------------------------------------------------------------ |
| `documentStatusEnum`                                                           | List\<*String*>                                                                | :heavy_minus_sign:                                                             | All possible document status values                                            | [<br/>"NOT_STARTED",<br/>"IN_PROGRESS",<br/>"CANCELED",<br/>"SUCCEEDED",<br/>"FAILED"<br/>] |
| `documents`                                                                    | List\<[BulkJobEmbeddedItems](../../models/components/BulkJobEmbeddedItems.md)> | :heavy_minus_sign:                                                             | List of documents with presigned upload URLs                                   |                                                                                |